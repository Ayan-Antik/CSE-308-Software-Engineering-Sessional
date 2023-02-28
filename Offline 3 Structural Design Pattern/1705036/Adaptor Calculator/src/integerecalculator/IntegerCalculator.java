package integerecalculator;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class IntegerCalculator {

    public void calculateSum(File file) throws Exception {
        Scanner sc = new Scanner(file);
        String line;

        ArrayList <Integer> arr = new ArrayList<>();
        while (sc.hasNextLine()){
            line = sc.nextLine();
            //arrStr = line.split(" ");

            for(String a: line.split(" ")){
                try {
                    arr.add(Integer.parseInt(a));
                }catch (NumberFormatException ne){
                    System.out.println("Not Integer Numbers");
                    break;
                }
            }
        }
        //System.out.println(arr);
        int sum = 0;
        for (int i = 0; i<arr.size(); i++){
            sum += arr.get(i);
        }
        System.out.println("Sum of the numbers: " + sum);
    }
}
