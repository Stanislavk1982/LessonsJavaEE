package client_manager_system;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ClienManagerSystemExecutor extends ThreadPoolExecutor {

    private Map<ClientRunnableEntry, Object> clientInProgressMap = new ConcurrentHashMap();
    private BlockingQueue<ClientRunnableEntry> waitClientQueue = new LinkedBlockingQueue();
    private ReentrantLock lock = new ReentrantLock();



    public ClienManagerSystemExecutor() {
        super(4, 4, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            lock.lock();
            Object client = null;
            ClientRunnableEntry clientInProgress = null;
            for (ClientRunnableEntry clientRunnableEntry : clientInProgressMap.keySet()) {
                if (r.equals(clientRunnableEntry.getRf())) {
                    client = clientRunnableEntry.client;
                    clientInProgress = clientRunnableEntry;
                    clientInProgressMap.remove(clientInProgress);
                    System.out.println("remove from main clientMAP->" + client);
                    break;
                }
            }

            for (ClientRunnableEntry clientInWait : waitClientQueue) {
                if (clientInWait.equals(clientInProgress)) {
                    waitClientQueue.remove(clientInWait);
                    clientInProgressMap.put(clientInWait, client);
                    System.out.println("remote from queue->" + client);
                    execute(clientInWait.getRf());
                }
            }
        } finally {
            lock.unlock();
        }
    }


    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<T> ftask = newTaskFor(task, result);
        ClientRunnableEntry clientRunnableEntry = new ClientRunnableEntry(ftask, result);
        if (clientInProgressMap.containsKey(clientRunnableEntry)) {
            waitClientQueue.add(clientRunnableEntry);
        } else {
            clientInProgressMap.put(clientRunnableEntry, result);
            execute(clientRunnableEntry.getRf());
        }
       // execute(ftask);
        return ftask;
    }



    class ClientRunnableEntry<T> {
        private RunnableFuture rf;
        private T client;

        public ClientRunnableEntry(RunnableFuture rf, T client) {
            this.rf = rf;
            this.client = client;
        }

        public RunnableFuture getRf() {
            return rf;
        }

        public void setRf(RunnableFuture rf) {
            this.rf = rf;
        }

        public T getClient() {
            return client;
        }

        public void setClient(T client) {
            this.client = client;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClientRunnableEntry<?> that = (ClientRunnableEntry<?>) o;

            return client.equals(that.client);

        }

        @Override
        public int hashCode() {
            return client.hashCode();
        }
    }

}
