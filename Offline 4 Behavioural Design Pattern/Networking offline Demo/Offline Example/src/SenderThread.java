import java.net.*;
import java.io.*;

public class SenderThread implements Runnable {

    Socket s;
    String username = null;
    boolean loggedIn = false;
    LMessage login = new LMessage();

    public SenderThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try{

            PrintWriter pr = new PrintWriter(s.getOutputStream(),true);
        while(true) {
            System.out.print("Message: ");
            BufferedReader msgType = new BufferedReader(new InputStreamReader(System.in));
            String Type = msgType.readLine();

            if (Type.equalsIgnoreCase("L")) {
                if (!loggedIn) {
                    System.out.println("Username: ");
                    BufferedReader info = new BufferedReader(new InputStreamReader(System.in));
                    login.setUser(info.readLine());
                    username = login.getUser();

                    System.out.println("Password: ");
                    login.setPass(info.readLine());

                    System.out.println("ClientType: ");
                    login.setType(info.readLine());

                    String messageToServer = login.textForServer();

                    pr.println(messageToServer);
                    loggedIn = true;
                    // pr.flush();

                    //System.out.println(receiveThread.username + " " + login.getUser());
                } else if (loggedIn)
                    System.out.println("Already Logged In!");


            } else if (Type.equalsIgnoreCase("S")) {

                try {
                    if (loggedIn) {
                        System.out.println("Send A Message To Server: ");

                        BufferedReader smessageToServer = new BufferedReader(new InputStreamReader(System.in));
                        SMessage sMessage = new SMessage(username, smessageToServer.readLine());
                        String messageToServer = sMessage.textForServer();
                        //PrintWriter prSms = new PrintWriter(s.getOutputStream(), true);                   //flush is true
                        pr.println(messageToServer);

                        if (sMessage.getText().equalsIgnoreCase("logout")) {
                            System.out.println("Logging out...");
                            System.exit(1);
                        }

                        else if (sMessage.getText().equalsIgnoreCase("show")) {
                            //System.out.println("Users: " + br.readLine());
                            //System.out.println("In that else if");
                            //showMessage = "show";
                            //System.out.println(receiveThread.receivedMessage);
                        }
                    }

                    else System.out.println("Please Log In first");

                } catch (NullPointerException e) {
                    System.out.println("Please Log in first");

                }
            }

            else if (Type.equalsIgnoreCase("B")) {
                if(login.getType().equalsIgnoreCase("admin")) {
                    try {
                        System.out.println("BroadCast A Message To Other Clients: ");

                        BufferedReader bmessageToServer = new BufferedReader(new InputStreamReader(System.in));
                        BMessage bMessage = new BMessage(username, bmessageToServer.readLine());
                        String messageToServer = bMessage.textForServer();
                        // System.out.println(messageToServer);
                        pr.println(messageToServer);
//                        System.out.println(br.readLine());


                    } catch (NullPointerException e) {
                        System.out.println("Please Log in first");

                    }
                }
                else System.out.println("You My friend, are NOT an admin");
            }
            else if (Type.equalsIgnoreCase("C")) {

                try {
                    System.out.println("Choose Receiver: ");
                    BufferedReader receiver = new BufferedReader(new InputStreamReader(System.in));
                    String Receiver = receiver.readLine();
                    System.out.println("Send Text: ");
                    BufferedReader cmessageToServer = new BufferedReader(new InputStreamReader(System.in));
                    CMessage cMessage = new CMessage(login.getUser(),Receiver, cmessageToServer.readLine());
                    String messageToServer = cMessage.textForServer();
                    // System.out.println(messageToServer);
                    pr.println(messageToServer);
//                        System.out.println(br.readLine());


                } catch (NullPointerException e) {
                    System.out.println("Please Log in first");

                }
            }
        }
        }catch (Exception e){
            System.out.println("Exception in senderThread");
            e.printStackTrace();
        }

    }
}
