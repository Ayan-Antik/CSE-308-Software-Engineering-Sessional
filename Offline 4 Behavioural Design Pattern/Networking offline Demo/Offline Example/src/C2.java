import java.net.*;

public class C2 {
    private static Socket s;

    public static void main(String[] args) {



        try {

            s = new Socket("localhost", 666);

            SenderThread senderThread = new SenderThread(s);
            Thread t2 = new Thread(senderThread);
            t2.start();

            ReceiveThread receiveThread = new ReceiveThread(s);
            Thread t = new Thread(receiveThread);
            t.start();


        }catch(Exception e){
            System.out.println("Error in Try Catch of Client.");
            e.printStackTrace();
        }
    }

}





