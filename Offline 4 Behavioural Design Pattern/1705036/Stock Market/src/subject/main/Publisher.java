package subject.main;

import subject.observer.ObserverThread;
import subject.stock.Stock;

import java.io.*;
import java.net.*;
import java.util.*;

public class Publisher {
    public static List<Stock> stocks;

    public static void main(String[] args) {
        int id = 1;
        try {
            File f = new File("");
            BufferedReader br = new BufferedReader(new FileReader("src\\data.txt"));
            String line;
            stocks = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                Stock stock = new Stock(split[0], Integer.parseInt(split[1]), Float.parseFloat(split[2]));
                stocks.add(stock);
                //System.out.println(stock.getName() + " " + stock.getCount() + " " + stock.getPrice());
            }
            ServerSocket ss = new ServerSocket(666);
            System.out.println("Server started");

            Admin at = new Admin();
            Thread t2 = new Thread(at);
            t2.start();

            while (true){
                Socket s = ss.accept();
                ObserverThread wt = new ObserverThread(s, id);

                Thread t = new Thread(wt);
                t.start();


                System.out.println("New User(" + id + ") created");
                id++;
            }
        }catch (Exception e){
            System.out.println("Error in publisher");
        }
    }
}
