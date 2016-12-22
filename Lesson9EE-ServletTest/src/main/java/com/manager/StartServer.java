package com.manager;


import com.controler.AsyncUserServlet;
import com.controler.UserController;
import com.filters.AuthFilter;
import com.filters.CorrectInputFilter;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;


public class StartServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(new QueuedThreadPool(10));
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(9997);
        server.setConnectors(new Connector[]{connector});



        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("/");


        servletContextHandler.addFilter(AuthFilter.class, "/usersAsync1/*", null);
        servletContextHandler.addFilter(CorrectInputFilter.class, "/usersAsync1/*", null);

        servletContextHandler.addServlet(UserController.class, "/users").setAsyncSupported(true);
        servletContextHandler.addServlet(AsyncUserServlet.class, "/usersAsync1");

        server.setHandler(servletContextHandler);
        server.start();
        server.join();


    }
}
