public class Sort{
    
    public int[] SelectionSort(int[] arr){

        int i, j, temp, idx, min;
        for(i = 0; i<arr.length-1; i++){
            min = arr[i];
            idx = i;

            for(j = i+1; j<arr.length; j++){
                if(arr[j] < min){
                    idx = j;
                    min = arr[j];
                }
            }
            temp = arr[i];
            arr[i] = min;
            arr[idx] = temp;

        }
        
        /*arr = new int[arr.length];
        for(i = 0; i< arr.length; i++){
            arr[i] = (int)(Math.random()*100);
        }*/
        return arr;
    }


}

