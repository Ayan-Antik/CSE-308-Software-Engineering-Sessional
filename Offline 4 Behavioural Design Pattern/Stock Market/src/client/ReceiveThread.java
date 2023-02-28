package client;

import java.io.*;
import java.net.*;

public class ReceiveThread implements Runnable {
    Socket s;
    public ReceiveThread(Socket s){
        this.s = s;
    }
    @Override
    public void run() {
        String ReceivedMessage = null;
        try {
            BufferedReader  br = new BufferedReader(new InputStreamReader(s.getInputStream()));


            while (true) {
                try {
                    ReceivedMessage = br.readLine();
                }catch (SocketException e){
                    System.out.println("Server Disconnected");
                    break;
                }

                if (ReceivedMessage.charAt(0) == 's') {
                    ShowStocks(ReceivedMessage);
                }

                else{
                    System.out.println(ReceivedMessage);
                }

            }
        }catch (IOException e) {
                System.out.println("Error in Client Receive Thread ");
            }
        }


    private void ShowStocks(String stocks){
        String[] lines = stocks.split("#");
        System.out.println("Current Stocks List: ");
        for(int i = 1; i<lines.length; i++){
            System.out.println(lines[i]);
        }
    }
}
