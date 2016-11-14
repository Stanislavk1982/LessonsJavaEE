package jmx_test;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class JMXTest {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        SystemManagerMBean systemManagerMBean = new SystemManager();
        platformMBeanServer.registerMBean(systemManagerMBean,
                new ObjectName("test:name=system_manager"));
        Thread.sleep(Integer.MAX_VALUE);
    }
}
