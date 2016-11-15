package com.stas;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class SystemManager implements SystemManagerMBean {
    private String destination;

    public String getDestination() {
        System.out.println("get destination:" + destination);
        return destination;
    }

    public void setDestination(String destination) {
        System.out.println("set destination:" + destination);
        this.destination = destination;
    }

    public void readFileByURL(String urlAdress, String destination) throws IOException {
        URL url = new URL(urlAdress);
        try (BufferedInputStream bis = new BufferedInputStream(url.openStream());
             FileOutputStream fos = new FileOutputStream(destination);) {


            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = bis.read(buffer, 0, 1024)) != -1) {
                fos.write(buffer, 0, count);
            }
        }
    }
}
