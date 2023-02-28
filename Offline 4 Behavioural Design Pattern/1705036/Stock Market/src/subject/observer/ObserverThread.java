package subject.observer;

import subject.main.Publisher;

import java.io.*;
import java.net.*;

public class ObserverThread implements Runnable,Observer{
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    public int id;
    public ObserverThread(Socket socket, int id){
        this.socket = socket;
        try {
            this.is = this.socket.getInputStream();
            this.os = this.socket.getOutputStream();
        }catch (Exception e){
            e.printStackTrace();
        }
        this.id = id;
    }
    @Override
    public void run() {

        try {
            SendStockInfo();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while (true){

                String clientmsg = br.readLine();
                //System.out.println(clientmsg);
                String[] splitmsg = clientmsg.split("#");

                if(splitmsg[0].equalsIgnoreCase("s")){
                        //ADD SUBSCRIBER TO THE STOCK

                    SubscribeToStock(splitmsg[1]);
                }
                else if(splitmsg[0].equalsIgnoreCase("u")){
                    UnsubscribeFromStock(splitmsg[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error in ObserverThread");
        }



    }

    private void UnsubscribeFromStock(String stockname) {
        for(int i = 0; i< Publisher.stocks.size(); i++){
            if(Publisher.stocks.get(i).getName().equalsIgnoreCase(stockname)){
                Publisher.stocks.get(i).unsubscribe(this);
            }
        }
        System.out.println("User " + id + " unsubscribed from stock " + stockname);
    }

    private void SubscribeToStock(String stockname) {
        for(int i = 0; i< Publisher.stocks.size(); i++){
            if(Publisher.stocks.get(i).getName().equalsIgnoreCase(stockname)){
                Publisher.stocks.get(i).subscribe(this);
            }
        }
        System.out.println("User " + id + " subscribed to stock " + stockname);
    }

    public void SendStockInfo() throws IOException {

        PrintWriter pr = new PrintWriter(os, true);

        String allstocks = "s#";
        for(int i = 0; i< Publisher.stocks.size(); i++){

            allstocks += Publisher.stocks.get(i).getName() + " ";
            allstocks += Publisher.stocks.get(i).getCount() + " ";
            allstocks += Publisher.stocks.get(i).getPrice() + "#";
        }

        pr.println(allstocks);
        //System.out.println(allstocks);
    }

    @Override
    public void update(String Notification) {

        //System.out.println("Sending notif...");
        PrintWriter pr = new PrintWriter(os, true);
        pr.println(Notification);
    }


}
