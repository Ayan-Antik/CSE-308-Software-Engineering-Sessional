import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;


class SortTest {
    Sort sort = new Sort();
    int[] mainarr;
    int[] sorted;
    Random random = new Random();


    @Test
    void Blank(){
        System.out.println("Blank:");
        mainarr = new int[0];
        sorted = mainarr.clone();

        sorted = sort.SelectionSort(sorted);

        Assertions.assertTrue(elementExistance());
        Assertions.assertTrue(sortingOrder());
    }

    @Test
    void Single(){
        System.out.println("Single:");
        mainarr = new int[1];
        mainarr[0] = random.nextInt();
        //System.out.println(mainarr[0]);
        sorted = mainarr.clone();

        sorted = sort.SelectionSort(sorted);

        Assertions.assertTrue(elementExistance());
        Assertions.assertTrue(sortingOrder());
    }

    @Test
    void Double(){
        System.out.println("Double:");
        mainarr = new int[2];
        mainarr[0] = random.nextInt();
        mainarr[1] = random.nextInt();
        //System.out.println(mainarr[0]);
        sorted = mainarr.clone();

        sorted = sort.SelectionSort(sorted);

        Assertions.assertTrue(elementExistance());
        Assertions.assertTrue(sortingOrder());
    }

    @Test
    void RandSize(){
        System.out.println("Random Size Array:");
        mainarr = new int[random.nextInt(20000)+1];
        for(int i = 0; i<mainarr.length; i++){
            mainarr[i] = random.nextInt();
        }
        //System.out.println(mainarr[0]);
        sorted = mainarr.clone();

        sorted = sort.SelectionSort(sorted);

        Assertions.assertTrue(elementExistance());
        Assertions.assertTrue(sortingOrder());
    }

    @Test
    void RandElem(){
        System.out.println("Random Element Array:");
        //mainarr = new int[random.nextInt(5000)+1];
        mainarr = new int[1000];
        for(int i = 0; i<mainarr.length; i++){
            mainarr[i] = random.nextInt();
            //System.out.println(mainarr[i]);
        }

        sorted = mainarr.clone();

        sorted = sort.SelectionSort(sorted);

        Assertions.assertTrue(elementExistance());
        Assertions.assertTrue(sortingOrder());
    }

    @Test
    void Ascend(){
        System.out.println("Sorted(ascending):");
        //mainarr = new int[random.nextInt(5000)+1];
        mainarr = new int[1000];
        for(int i = 0; i<mainarr.length; i++){
            mainarr[i] = i;
            //System.out.print(i + " ");
        }
       // System.out.println();
        sorted = mainarr.clone();

        sorted = sort.SelectionSort(sorted);

        Assertions.assertTrue(elementExistance());
        Assertions.assertTrue(sortingOrder());
    }

    @Test
    void Descend(){
        System.out.println("Sorted(descending):");
        //mainarr = new int[random.nextInt(5000)+1];
        mainarr = new int[1000];
        for(int i = 0; i<mainarr.length; i++){
            mainarr[i] = mainarr.length-1-i;
           //System.out.print(mainarr[i] + " ");
        }
        //System.out.println();
        sorted = mainarr.clone();

        sorted = sort.SelectionSort(sorted);

        Assertions.assertTrue(elementExistance());
        Assertions.assertTrue(sortingOrder());
    }

    @Test
    void Equals(){
        System.out.println("Equals:");
        //mainarr = new int[random.nextInt(5000)+1];

        mainarr = new int[1000];
        int num = random.nextInt();
        for(int i = 0; i<mainarr.length; i++){
            mainarr[i] = num;
        }

        sorted = mainarr.clone();

        sorted = sort.SelectionSort(sorted);

        Assertions.assertTrue(elementExistance());
        Assertions.assertTrue(sortingOrder());
    }
    //EXTRAS
    @Test
    void Negatives(){
        System.out.println("Negatives:");
        //mainarr = new int[random.nextInt(5000)+1];
        mainarr = new int[1000];

        for(int i = 0; i<mainarr.length; i++){
            mainarr[i] = -random.nextInt(10000);
            //System.out.println(mainarr[i]);
        }

        sorted = mainarr.clone();

        sorted = sort.SelectionSort(sorted);

        Assertions.assertTrue(elementExistance());
        Assertions.assertTrue(sortingOrder());
    }

    @Test
    void Positives(){
        System.out.println("Positives:");
        //mainarr = new int[random.nextInt(5000)+1];
        mainarr = new int[1000];

        for(int i = 0; i<mainarr.length; i++){
            mainarr[i] = random.nextInt(10000);
            //System.out.println(mainarr[i]);
        }

        sorted = mainarr.clone();

        sorted = sort.SelectionSort(sorted);

        Assertions.assertTrue(elementExistance());
        Assertions.assertTrue(sortingOrder());
    }

    @Test
    void Zeros(){
        System.out.println("Zeros:");
        //mainarr = new int[random.nextInt(5000)+1];
        mainarr = new int[1000];

        for(int i = 0; i<mainarr.length; i++){
            mainarr[i] = 0;
            //System.out.println(mainarr[i]);
        }

        sorted = mainarr.clone();

        sorted = sort.SelectionSort(sorted);

        Assertions.assertTrue(elementExistance());
        Assertions.assertTrue(sortingOrder());
    }

    @Test
    void Null(){
        System.out.println("Null:");
        try {

            sorted = sort.SelectionSort(sorted);

            Assertions.assertTrue(elementExistance());
            Assertions.assertTrue(sortingOrder());
        }catch (NullPointerException ne){
            System.out.println("\tNull Pointer Exception");
            //ne.printStackTrace();
        }

    }

    boolean sortingOrder() {

        for(int i = 0; i<sorted.length-1; i++){
            if(sorted[i] > sorted[i+1]){
                System.out.println("\tSorting Error");
                return false;
            }
        }
        System.out.println("\tSuccesful Sort");
        return true;
    }


    boolean elementExistance(){
        int matched = 0;
        for(int i = 0; i< mainarr.length; i++){
            for (int j = 0; j<sorted.length; j++){
                if(mainarr[i] == sorted[j]){
                    matched++;
                    mainarr[i] = Integer.MIN_VALUE;
                }
            }
        }

        if(matched == mainarr.length){
            System.out.println("\tElements Matched");
            return true;

        }
        System.out.println("\tElement Altered");
        return false;

    }
}