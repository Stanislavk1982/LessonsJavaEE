package client_manager_system;

import java.util.concurrent.Callable;

public class ClientTask implements Callable{

    private Client client;

    public ClientTask(Client client) {
        this.client = client;
    }

    public Object call() throws Exception {
        return null;
    }
}
