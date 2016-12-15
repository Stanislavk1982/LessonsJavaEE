package ws_test;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by BGClassTeacher on 17.11.2016.
 */

@ServerEndpoint("/chat")
public class CustomServerSocket {

    @OnOpen
    public void onConnect(Session session) {
        System.out.println("server:: connection is available");
    }

    @OnMessage
    public String onMessage(Session session, String msg) throws IOException {
        System.out.println("server:: message -> " + msg);
        if("exit".equals(msg)){
            session.close(new CloseReason(CloseReason.CloseCodes.CANNOT_ACCEPT, "exit"));
        }
        return msg;
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason){
        System.out.println("server:: disconnect " + closeReason.getReasonPhrase());
    }

}
