import charadapter.charAdapter;
import integerecalculator.IntegerCalculator;

import java.io.File;
import java.util.Scanner;

public class AdapterDemo {

    public static void main(String[] args) throws Exception {
        File f = new File("src\\input.txt");

        IntegerCalculator ic;
        /*ic.calculateSum(f);*/

        Scanner s = new Scanner(System.in);
        System.out.println("Read From File:\n1. Integer\n2. Character");
        int choice = s.nextInt();
        if(choice == 1){
            ic = new IntegerCalculator();
            ic.calculateSum(f);
        }
        else if(choice == 2){
            ic = new charAdapter();
            ic.calculateSum(f);
        }

    }

}
