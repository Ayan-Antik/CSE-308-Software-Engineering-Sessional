import java.net.*;
import java.util.ArrayList;
import java.util.List;


public class Server {

    public static int workerThreadCount = 0;
    public static ArrayList<String> e = new ArrayList<>();

    static List<WorkerThread> wtList = new ArrayList<>();

    public static void main(String[] args) {

        int id = 1;


        try {
            ServerSocket ss = new ServerSocket(666);
            System.out.println("Server has been started succesfully");
            while (true) {
                Socket s = ss.accept();     //TCP Connection
                WorkerThread wt = new WorkerThread(s, id);
                e.add(String.valueOf(id));
                wtList.add(wt);
                Thread t = new Thread(wt);
                t.start();
                workerThreadCount++;
                System.out.println("Client [" + id + "] is now connected. No. of worker threads = " + workerThreadCount);
                id++;
            }
        } catch (Exception e) {
            System.out.println("Problem in Server Socket Try Block");
            e.printStackTrace();
        }
    }

}
