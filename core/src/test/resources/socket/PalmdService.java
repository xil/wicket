package socket;

/**
 * Created with IntelliJ IDEA.
 * User: shakhov
 * Date: 11/24/13
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PalmdService {

    void pingPalmd();

    void getStatus();

    void startEnroll();

    void stopEnroll();

    void getHint();

    void sendScan();

    void getScan();

}
