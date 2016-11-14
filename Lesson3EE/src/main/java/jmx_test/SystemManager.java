package jmx_test;

public class SystemManager implements SystemManagerMBean {
    private int threadCount;

    public int getThreadCount() {
        System.out.println("get threadCount:" + threadCount);
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        System.out.println("set threadCount:" + threadCount);
        this.threadCount = threadCount;
    }

    public void dosomething() {
        System.out.println("test111111");
    }
}
