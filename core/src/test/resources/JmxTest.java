/*
 * Copyright (c) 2013 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */


import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 8/20/13
 * Time: 11:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class JmxTest {

    public static void main(String[] args) {
        String host = "localhost";  // or some A.B.C.D
        int port = 7777;
        String url = "service:jmx:rmi:///jndi/rmi://" + host + ":" + port + "/jmxrmi";
        try {
            JMXServiceURL serviceUrl = new JMXServiceURL(url);
            JMXConnector jmxConnector = JMXConnectorFactory.connect(serviceUrl, null);
            MBeanServerConnection mbeanConn = jmxConnector.getMBeanServerConnection();
            Set<ObjectName> objectNames = mbeanConn.queryNames(new ObjectName("bean:service=SignalMBean"), null);
            Object[] argArray = new Object[]{"33,99"};
            String[] signature = new String[]{"java.lang.Object"};
            for (ObjectName bean : objectNames) {
                mbeanConn.invoke(bean, "notifyId", argArray, signature);
                break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
        catch (ReflectionException e) {
            e.printStackTrace();
        } catch (MBeanException e) {
            e.printStackTrace();
        } catch (InstanceNotFoundException e) {
            e.printStackTrace();
        }
    }
}
