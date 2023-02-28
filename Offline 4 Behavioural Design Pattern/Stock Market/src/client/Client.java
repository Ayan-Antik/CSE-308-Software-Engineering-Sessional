package client;

import java.io.IOException;
import java.net.*;

public class Client {

    private static Socket s;
    public static void main(String[] args) throws IOException {
        s = new Socket("localhost", 666);

        SendThread sendThread = new SendThread(s);
        Thread t = new Thread(sendThread);
        t.start();

        ReceiveThread receiveThread = new ReceiveThread(s);
        Thread t2 = new Thread(receiveThread);
        t2.start();

    }
}
