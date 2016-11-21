package client_manager_system;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ClientMSExecutorTest {
    public static void main(String[] args) {
        List<Client> clients = Arrays.asList(
                new Client(1, "X1", "x1"),
                new Client(2, "X2", "x2"),
                new Client(3, "X3", "x3"),
                new Client(4, "X4", "x4"),
                new Client(5, "X5", "x5"),
                new Client(6, "X6", "x6")
        );
        List<ClientTask> clientTaskList = Arrays.asList(
                new ClientTask(clients.get(0)),
                new ClientTask(clients.get(0)),
                new ClientTask(clients.get(1)),
                new ClientTask(clients.get(2)),
                new ClientTask(clients.get(2)),
                new ClientTask(clients.get(3))
        );

        ClienManagerSystemExecutor clienManagerSystemExecutor = new ClienManagerSystemExecutor();
        for (ClientTask clientTask : clientTaskList) {
            clienManagerSystemExecutor.submit(clientTask, clientTask.getClient());
        }
    }
}
