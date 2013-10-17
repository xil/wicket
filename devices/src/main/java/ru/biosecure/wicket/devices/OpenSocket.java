package ru.biosecure.wicket.devices;

//
//  Hello World server in Java
//  Binds REP socket to tcp://*:5555
//  Expects "Hello" from client, replies with "World"
//

import org.zeromq.ZMQ;

public class OpenSocket{

    public static String main (String request) throws Exception{
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.REQ);
        socket.connect ("tcp://127.0.0.1:5555");
        socket.send(request.getBytes (), 0);
        byte[] reply = socket.recv(0);
        String str = new String(reply, "cp1251");
        socket.close();
        context.term();
        return str;
    }
}