package jmx_test;

public interface SystemManagerMBean {
    int getThreadCount();

    void setThreadCount(int threadCount);
}
