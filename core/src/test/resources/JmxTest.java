
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

    public static final int PORT = 7777;
    public static final String HOST = "localhost";
    public static final String MBEAN_MANE = "bean:service=SignalMBean";
    public static final String TYPE = "java.lang.Object";
    public static final String OPERATION_NAME = "notifyId";

    public static void main(String[] args) {
        if (args == null || args.length == 0) return;
        String url = "service:jmx:rmi:///jndi/rmi://" + HOST + ":" + PORT + "/jmxrmi";
        try {
            JMXServiceURL serviceUrl = new JMXServiceURL(url);
            JMXConnector jmxConnector = JMXConnectorFactory.connect(serviceUrl, null);
            if (jmxConnector == null) return;
            MBeanServerConnection mbeanConn = jmxConnector.getMBeanServerConnection();
            if (mbeanConn == null) return;
            Set<ObjectName> objectNames = mbeanConn.queryNames(new ObjectName(MBEAN_MANE), null);
            if (objectNames == null || objectNames.isEmpty()) return;
            Object[] argArray = new Object[]{args};
            String[] signature = new String[]{TYPE};
            for (ObjectName bean : objectNames) {
                mbeanConn.invoke(bean, OPERATION_NAME, argArray, signature);
                break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (ReflectionException e) {
            e.printStackTrace();
        } catch (MBeanException e) {
            e.printStackTrace();
        } catch (InstanceNotFoundException e) {
            e.printStackTrace();
        }
    }
}
