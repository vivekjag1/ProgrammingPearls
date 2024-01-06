import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();

      arr.add(5);
      arr.add(4);
      arr.add(3);
      arr.add(2);
      arr.add(1);
      arr.add(0);

        ArrayList<Integer> arr2 = new ArrayList<>();

        arr2.add(5);
        arr2.add(4);
        arr2.add(3);
        arr2.add(2);
        arr2.add(1);
        arr2.add(0);
        Sorter sort = new Sorter(arr);
ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(5);
        arr3.add(4);
        arr3.add(3);
        arr3.add(2);
        arr3.add(1);
        arr3.add(0);

        ArrayList<Integer> arr4 = new ArrayList<>();
        arr4.add(5);
        arr4.add(4);
        arr4.add(3);
        arr4.add(2);
        arr4.add(1);
        arr4.add(0);

        Sorter sorter2 = new Sorter(arr2);
        System.out.println("Quick sort: " + sorter2.quickSort(arr2));
        System.out.println("Basic insertion sort: " + sort.insertionSort());
        Sorter enhanced = new Sorter(arr3);
        System.out.println("Enhanced insertion sort: " + enhanced.betterInsertionSort());


    }
}
