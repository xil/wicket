package ru.biosecure.wicket.devices;

/**
 * Created with IntelliJ IDEA.
 * User: 1234567890
 * Date: 17.10.13
 * Time: 18:16
 * To change this template use File | Settings | File Templates.
 */
import org.zeromq.ZMQ;
import java.util.*;

public class SensorSocket {

    public static void main () throws Exception{
        ZMQ.Context context = ZMQ.context(1);
        //  Socket to talk to clients
        ZMQ.Socket socket = context.socket(ZMQ.REP);
        socket.bind ("tcp://*:5556");

        while (!Thread.currentThread ().isInterrupted ()) {
            byte[] reply = socket.recv(0);
            String str = new String(reply, "cp1251");
            if (str=="l-sensor")
            {
                String request = "l-sensor-OK";
                socket.send(request.getBytes(), 0);
                if (OpenSocket.main("left")=="left-OK");
                //то мы знаем что турникет открылся влево
            }
            else if(str=="r-sensor")
            {
                String request = "r-sensor-OK";
                socket.send(request.getBytes(), 0);
                if (OpenSocket.main("right")=="right-OK");
                //то мы знаем что турникет открылся вправо
            }
            Thread.sleep(100); //  Do some 'work'
        }
        socket.close();
        context.term();
    }
}