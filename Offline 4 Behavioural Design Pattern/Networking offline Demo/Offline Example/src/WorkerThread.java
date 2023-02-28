import java.io.*;
import java.net.*;
import java.util.*;


public class WorkerThread implements Runnable{

    private static List<String> LoggedInUser= new ArrayList<>();
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    public int id;
    String[] totalInfo = new String[6];

    public  WorkerThread(Socket socket,int id){
        this.socket = socket;

        try{
            this.is = this.socket.getInputStream();
            this.os = this.socket.getOutputStream();
        }catch (Exception e){
            System.err.println("Sorry. Cannot manage client [" + id + "] properly.");
        }
        this.id = id;

    }
    @Override
    public void run() {
        BufferedReader fromFile;
        try {
            fromFile = new BufferedReader(new FileReader("D:\\Study\\BUET\\L3T1\\CSE 308 Software Engineering Sessional\\Offline 4 Behavioural Design Pattern\\Networking offline Demo\\Offline Example\\src\\Data.txt"));
            for(int i = 0;i<6;i++){
                totalInfo[i] = fromFile.readLine();
                //System.out.println(totalInfo[i]);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        while(true){
            BufferedReader br = new BufferedReader(new InputStreamReader(this.is));

            try {

                String clientMessage = br.readLine();
               // System.out.println("Message from client: " + clientMessage);
                String[] splitMessage = clientMessage.split("#");

                if (splitMessage[0].equalsIgnoreCase("l"))
                    login(splitMessage);

                else if (splitMessage[0].equalsIgnoreCase("s")) {
                   // System.out.println(splitMessage[1]);
                    sms(splitMessage);
                }

                else if(splitMessage[0].equalsIgnoreCase("b")){
                        broadcast(splitMessage);
                }

                else if(splitMessage[0].equalsIgnoreCase("c"))
                    SpecificReceiver(splitMessage);

            } catch (Exception e) {
               // System.out.println("Exception in Run");

                //e.printStackTrace();
            }

        }
    }

    public void login(String[] s){


        try {
            PrintWriter toClient = new PrintWriter(socket.getOutputStream());


            for(int j = 0;j<6;j++){
               String[] splitInfo = totalInfo[j].split("#");
                //System.out.println(splitInfo[0] + " " + splitInfo[1] + " " + splitInfo[2]);
               if(splitInfo[0].equals(s[1]) && splitInfo[1].equals(s[2]) && splitInfo[2].equalsIgnoreCase(s[3])){
                  // System.out.println("Milse");
                   toClient.println(splitInfo[0] + "#" + "Log in Succesful" + "#");
                  // System.out.println("LoggedInUser BEFORE Add: " + LoggedInUser);
                   LoggedInUser.add(splitInfo[0]);                                     //adds USERNAME
                 //  System.out.println("LoggedInUser AFTER Add: " + LoggedInUser);
                   break;
               }
            else if(j == 6) {
                   System.out.println("Here");
                   System.exit(1);
               }
            }
            //System.out.println("In Login___username: " + s[1]);

            //fr.close();
            toClient.flush();

        } catch (Exception e) {
            System.out.println("LOG IN File Try Catch block exception found");
            e.printStackTrace();
        }
    }

    public void sms(String[] s){

        String smsFromClient = s[2];
        if(!smsFromClient.equalsIgnoreCase("show") && !smsFromClient.equalsIgnoreCase("logout")){
            System.out.println("Message from Client " + s[1] + ": " + smsFromClient);
        }
        else if(smsFromClient.equalsIgnoreCase("logout")){
           // System.out.println("Logged in user before remove: " + LoggedInUser);

            LoggedInUser.remove(s[1]);
            //System.out.println("First " + Server.e);
            Server.e.remove(String.valueOf(this.id));
           // System.out.println(Server.e);
           // System.out.println("Logged in user after remove: " + LoggedInUser);
        }

        else if(smsFromClient.equalsIgnoreCase("show")){
            PrintWriter toClient = new PrintWriter(this.os);
            String users = LoggedInUser.toString();
           // System.out.println(users);
            toClient.println(users);
            toClient.flush();

        }

    }

    public void broadcast(String[] s) throws IOException {

        List<WorkerThread> tempList =  Server.wtList;
     //   PrintWriter broadcastMessage = new PrintWriter(socket.getOutputStream());
        //System.out.println(Server.e.size());
        for(int i = 0;i<Server.e.size();i++) {
            if (tempList.get(i).id == this.id) {
                //System.out.println("id is: " + i);
                if (Server.e.size() == 1){
                    tempList.get(i).sendToClients("No One Else is Online");
                    break;
            }
               else {
                    tempList.get(i).sendToClients("Success!");
                    continue;
                }
        }
            else tempList.get(i).sendToClients(s[1] + " broadcasts: " + s[2]);

        }

    }
    public void sendToClients(String s) throws IOException {
        PrintWriter broadCast = new PrintWriter(socket.getOutputStream());
        //System.out.println("IN METHOD SEND TO CLIENTS");
        //System.out.println(s);
        broadCast.println(s);
        broadCast.flush();

    }

    public void SpecificReceiver(String[] s)throws Exception{
        int i;

        for(i = 0;i<LoggedInUser.size();i++){
            //System.out.println("Print Logged In users: " + LoggedInUser.get(i));
                if(LoggedInUser.get(i).equalsIgnoreCase(s[2])){
                    Server.wtList.get(i).send(s[1] + " says " + s[3]);
                    break;
                }

    }
        if(i == LoggedInUser.size()) {
            PrintWriter notLoggedIn = new PrintWriter(socket.getOutputStream(),true);
            notLoggedIn.println("User Not Logged In");
        }
}



    public void send(String s) throws IOException {
        PrintWriter broadCast = new PrintWriter(socket.getOutputStream());

        System.out.println("In SEND");
        //System.out.println("IN METHOD SEND TO CLIENTS");
        //System.out.println(s);
        broadCast.println(s);
        broadCast.flush();

    }
}