package ws_test;

import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

@ClientEndpoint
public class CustomClienSocket {

    @OnOpen
    public void onConnect(Session session) throws IOException {
        System.out.println("client:: ");

        session.getBasicRemote().sendText("hello from client");
    }

    @OnMessage
    public String onMessage(Session session, String msg) {
        System.out.println("client:: message" + msg+"---");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("disconnect::: reason->" + closeReason.getReasonPhrase());
    }
    public static void main(String[] args) throws URISyntaxException, DeploymentException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
//        new CustomClienSocket();
        ClientManager clientManager = new ClientManager();
        clientManager.connectToServer(CustomClienSocket.class, new URI("ws://localhost:9090/websockets/chat"));
        countDownLatch.await();
    }
}
