package ws_test;

import org.glassfish.tyrus.server.Server;

import javax.websocket.DeploymentException;
import java.util.Scanner;

/**
 * Created by BGClassTeacher on 17.11.2016.
 */
public class StartServer {

    public static void main(String[] args) throws DeploymentException {
        //String hostName, int port, String rootPath, Class... configuration
        Server server = new Server("localhost", 9090, "/websockets", CustomServerSocket.class);
        server.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        server.stop();


    }
}
