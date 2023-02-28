package client;

import java.io.*;
import java.net.*;

public class SendThread implements Runnable {
    Socket s;
    public SendThread(Socket s){
        this.s = s;
    }
    @Override
    public void run() {
        try {
            PrintWriter pr = new PrintWriter(s.getOutputStream(), true);

            while (true){
                System.out.println("Message: ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = br.readLine();
                line = consruct(line);
                pr.println(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String consruct(String line){
        String[] split = line.split(" ");
        String s = split[0] + "#" + split[1];
        return s;
    }
}
