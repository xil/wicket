package socket;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: shakhov
 * Date: 11/25/13
 * Time: 12:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class PalmdServiceImpl implements PalmdService {

    @Test
    public void pingPalmd() {
        String command = "ping=" + getUuid();
        String fromServer = SocketProcessor.sendCommand(command);
        Assert.assertEquals("wrong response", fromServer, command);
    }

    private String getUuid() {
        return UUID.randomUUID().toString();
    }

    @Test
    public void getStatus() {

    }

    @Test
    public void startEnroll() {

    }

    @Test
    public void stopEnroll() {

    }

    @Test
    public void getHint() {

    }

    @Test
    public void sendScan() {

    }

    @Test
    public void getScan() {

    }
}
