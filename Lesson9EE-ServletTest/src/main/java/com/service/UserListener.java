package com.service;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import java.io.IOException;

public class UserListener implements AsyncListener {
    public void onComplete(AsyncEvent asyncEvent) throws IOException {
        System.out.println("OK");
    }

    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        System.out.println("Time Out");
    }

    public void onError(AsyncEvent asyncEvent) throws IOException {
        System.out.println("Error");
    }

    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
        System.out.println("Start Async");
    }
}
