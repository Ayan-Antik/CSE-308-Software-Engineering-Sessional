public class Main {

    public static void main(String[] args) {

        int[] arr = {10, 5, 16, 96};

        Sort sort = new Sort();
        arr = sort.SelectionSort(arr);
        for (int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

}
