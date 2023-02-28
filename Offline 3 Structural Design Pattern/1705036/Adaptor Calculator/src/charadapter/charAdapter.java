package charadapter;

import integerecalculator.IntegerCalculator;

import java.io.*;
import java.util.Scanner;

public class charAdapter extends IntegerCalculator {

    @Override
    public void calculateSum(File file) throws Exception {

        Scanner sc = new Scanner(file);
        String line;
        File myfile = new File("D:\\Study\\BUET\\L3T1\\CSE 308 Software Engineering Sessional\\" +
                "Offline 3 Structural Design Pattern\\Adaptor Calculator\\src\\charadapter\\myfile.txt");
        FileWriter writer = new FileWriter(myfile);
        /*PrintWriter writer = new PrintWriter("D:\\Study\\BUET\\L3T1\\CSE 308 Software Engineering Sessional\\" +
                "Offline 3 Structural Design Pattern\\Adaptor Calculator\\src\\charadapter\\myfile.txt");*/


        while (sc.hasNextLine()){
            line = sc.nextLine();

            for(String a: line.split(" ")){

                //System.out.println(((int)a.charAt(0)));
                writer.write((int)a.charAt(0) + " ");
            }
        }
        writer.close();
        super.calculateSum(myfile);
    }
}
