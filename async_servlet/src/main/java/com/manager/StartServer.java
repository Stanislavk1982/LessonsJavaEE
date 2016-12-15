package com.manager;

import com.server.UserServlet;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class StartServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(new QueuedThreadPool(10));

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(9999);
        server.setConnectors(new Connector[]{connector});

        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("/");
        servletContextHandler.addServlet(UserServlet.class, "/users");
        servletContextHandler.addServlet(UserServlet.class, "/usersAsync");

        server.setHandler(servletContextHandler);

        server.start();
        server.join();



    }
}
