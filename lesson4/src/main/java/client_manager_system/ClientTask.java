package client_manager_system;

import java.util.concurrent.Callable;

/**
 * Created by BGClassTeacher on 17.11.2016.
 */
public class ClientTask implements Runnable {
    private Client client;

    public ClientTask(Client client) {
        this.client = client;
    }

    public void run() {
        System.out.println("client::" + client);

    }

    public Client getClient() {
        return client;
    }
}
