package client_manager_system;

import java.util.Arrays;
import java.util.List;

/**
 * Created by BGClassTeacher on 21.11.2016.
 */
public class ClientMSExecutorTest {
    public static void main(String[] args) {
        List<Client> clients = Arrays.asList(
                new Client(1, "x1", "x1"),
                new Client(2, "x2", "x2"),
                new Client(3, "x3", "x3"),
                new Client(4, "x4", "x4"),
                new Client(5, "x5", "x5")
        );
        List<ClientTask> clientTaskList = Arrays.asList(
                new ClientTask(clients.get(0)),
                new ClientTask(clients.get(0)),
                new ClientTask(clients.get(1)),
                new ClientTask(clients.get(2)),
                new ClientTask(clients.get(3))
        );

        ClientMSExecutor clientMSExecutor = new ClientMSExecutor();
        for (ClientTask clientTask : clientTaskList) {
            clientMSExecutor.submit(clientTask, clientTask.getClient());
        }


    }

}
