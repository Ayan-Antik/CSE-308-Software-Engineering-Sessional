import java.io.*;
import java.net.*;

public class C3 {
    private static Socket s;
    private static BufferedReader br;
    private static PrintWriter pr;

    public static void main(String[] args) {



        try {

            s = new Socket("localhost", 666);

            SenderThread senderThread = new SenderThread(s);
            Thread t2 = new Thread(senderThread);
            t2.start();

            ReceiveThread receiveThread = new ReceiveThread(s);
            Thread t = new Thread(receiveThread);
            t.start();

           /* while (true) {

                System.out.println("Type of Message: ");
                BufferedReader msgType = new BufferedReader(new InputStreamReader(System.in));
                String Type = msgType.readLine();

                if (Type.equalsIgnoreCase("L")) {
                    if (!receiveThread.loggedIn) {
                        System.out.println("Username: ");
                        BufferedReader info = new BufferedReader(new InputStreamReader(System.in));
                        login.setUser(info.readLine());
                        // username = login.getUser();

                        System.out.println("Password: ");
                        login.setPass(info.readLine());

                        System.out.println("ClientType: ");
                        login.setType(info.readLine());

                        String messageToServer = login.textForServer();

                        pr.println(messageToServer);
                        // pr.flush();

                        //System.out.println(receiveThread.username + " " + login.getUser());
                    }
                     else if (receiveThread.loggedIn)
                            System.out.println("Already Logged In!");


                }else if (Type.equalsIgnoreCase("S")) {

                        try {
                            if (!receiveThread.loginMessagefromServer.isBlank()) {
                                System.out.println("Send A Message To Server: ");

                                BufferedReader smessageToServer = new BufferedReader(new InputStreamReader(System.in));
                                SMessage sMessage = new SMessage(receiveThread.username, smessageToServer.readLine());
                                String messageToServer = sMessage.textForServer();
                                //PrintWriter prSms = new PrintWriter(s.getOutputStream(), true);                   //flush is true
                                pr.println(messageToServer);

                                if (sMessage.getText().equalsIgnoreCase("logout")) {
                                    System.out.println("Logging out");
                                    break;
                                }
                                else if (sMessage.getText().equalsIgnoreCase("show"))
                                {
                                    //System.out.println("Users: " + br.readLine());
                                       System.out.println("In that else if");
                                        receiveThread.showMessage = "show";
                                    //System.out.println(receiveThread.receivedMessage);
                            } else
                                  continue;

                            }
                        } catch (NullPointerException e) {
                            System.out.println("Please Log in first");

                        }
                    } else if (Type.equalsIgnoreCase("B")) {
                        try {
                            if (!receiveThread.loginMessagefromServer.isBlank()) {
                                System.out.println("BroadCast A Message To Other Clients: ");

                                BufferedReader bmessageToServer = new BufferedReader(new InputStreamReader(System.in));
                                BMessage bMessage = new BMessage(receiveThread.username, bmessageToServer.readLine());
                                String messageToServer = bMessage.textForServer();
                                System.out.println(messageToServer);
                                pr.println(messageToServer);
//                        System.out.println(br.readLine());

                            }
                        } catch (NullPointerException e) {
                            System.out.println("Please Log in first");

                        }
                    }
                    //System.out.println(br.readLine());
                }
*/

        }catch(Exception e){
            System.out.println("Error in Try Catch of Client.");
            e.printStackTrace();
        }
    }

}





