package com.stas;

import java.io.IOException;

public interface SystemManagerMBean {
    String getDestination();

    void setDestination(String destination);

    void readFileByURL(String urlAdress, String destination) throws IOException;
}
