package client_manager_system;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ClienManagerSystemExecutor extends ThreadPoolExecutor {

    public Map<ClientRunnableEntry, Object> clientInProgressMap = new ConcurrentHashMap();

    private BlockingQueue<ClientRunnableEntry> waitClientQueue = new LinkedBlockingQueue();


    public ClienManagerSystemExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                      TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(4, 4, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
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

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
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
