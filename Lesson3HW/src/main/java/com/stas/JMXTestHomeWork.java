package com.stas;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

public class JMXTestHomeWork {
    public static void main(String[] args) throws IOException, MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        ReadfromFile readfromFile = new ReadfromFile();
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        SystemManagerMBean systemManagerMBean = new SystemManager();
        platformMBeanServer.registerMBean(systemManagerMBean,
                new ObjectName("test:name=system_manager"));
        Scanner scanner = new Scanner(System.in);

        systemManagerMBean.setDestination("g:\\3\\1.java");
        while (true) {
            String msg = scanner.nextLine();
            System.out.println("message:" + msg);
            if (msg.equals("yes")) {
                systemManagerMBean.readFileByURL("https://github.com/Stanislavk1982/LessonsJavaEE/blob/master/Lesson3EE/src/main/java/jmx_test/JMXTest.java", systemManagerMBean.getDestination());
            }

        }


    }
}
