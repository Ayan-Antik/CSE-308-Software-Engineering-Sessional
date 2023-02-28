import java.io.*;
import java.net.*;
import java.util.*;

public class ReceiveThread implements Runnable{

    private Socket socket;
    public boolean loggedIn = false;
    public static String username;
    static String loginMessagefromServer = null;
    String showMessage = null;
    String receivedMessage = null;

    public ReceiveThread(Socket s) {
        socket = s;
    }

    @Override
    public void run(){
        try {
            //System.out.println("Receive Thread runnable e");

            BufferedReader receiver = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true) {
                try {
                    receivedMessage = receiver.readLine();
                }catch (SocketException e){
                    System.out.println("Server disconnected");
                }

                if(receivedMessage.endsWith("#")){
                String[] temp = receivedMessage.split("#");
                if (temp[1].equalsIgnoreCase("Log in Succesful")) {

                    System.out.println(temp[1]);
                    //System.out.println(temp[0]);
                    username = temp[0];
                    //System.out.println(username);
                    loggedIn = true;
                    loginMessagefromServer = temp[1];
                }
                } else if (receivedMessage.startsWith("[")) {
                    //System.out.println("In receive show");
                    //receivedMessage.replace("#"," ");
                    System.out.println("Users: " + receivedMessage);
                    //System.out.println("In received thread function: " + showMessage);
                }
                else System.out.println(receivedMessage);
            }
        }catch (Exception e){
            System.out.println("Exception in ReceiveThread runnable method");
        }
    }
}
