import mediator.JCC;
import mediator.Mediator;
import services.JPDC;
import services.JRTA;
import services.JTRC;
import services.JWSA;

import java.util.Scanner;

public class MediatorPatternDemo {
    public static void main(String[] args) {
        JCC jcc = null;

        JWSA jwsa = null;
        JPDC jpdc = null;
        JTRC jtrc = null;
        JRTA jrta = null;
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] words = input.split(" ");
        while (!words[0].equalsIgnoreCase("exit")){
            if(words[0].equalsIgnoreCase("init")){
                jcc = new JCC();

                jwsa = new JWSA(jcc);
                jpdc = new JPDC(jcc);
                jtrc = new JTRC(jcc);
                jrta = new JRTA(jcc);

                jcc.setJwsa(jwsa);
                jcc.setJpdc(jpdc);
                jcc.setJrta(jrta);
                jcc.setJtrc(jtrc);
                System.out.println("All four services are initiated through mediator");
            }
            else if(words[1].equalsIgnoreCase("serve")){
                if(words[0].equalsIgnoreCase("jwsa")){
                    jwsa.serve();
                }
                else if(words[0].equalsIgnoreCase("jpdc")){
                    jpdc.serve();
                }
                else if(words[0].equalsIgnoreCase("jrta")){
                    jrta.serve();
                }
                else if(words[0].equalsIgnoreCase("jtrc")){
                    jtrc.serve();
                }
            }

            else {

                    jcc.requestService(words[0], words[1]);

            }
            input = sc.nextLine();
            words = input.split(" ");
        }


    }


}
