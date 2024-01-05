import java.util.ArrayList;

public class Main {
    public static void main (String[] args){
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        BinarySearch runner = new BinarySearch(myList);
        long start =System.nanoTime();
        System.out.println(runner.find(myList, 3));
        long end = System.nanoTime();
        long unoptimized = end - start;
        System.out.println("Unoptimized binary search took: " + unoptimized);

        ArrayList<Integer> myList2 = new ArrayList<>();
        myList2.add(1);
        myList2.add(2);
        myList2.add(3);
        myList2.add(4);
        BinarySearch runner2 = new BinarySearch(myList2);
        start = System.nanoTime();
        System.out.println(runner2.findFast(myList2, 3));
        end = System.nanoTime();
        long optimized = end - start;
        System.out.println("Optimized binary search took: " + optimized);



        System.out.println("The unoptimized binary search took " + unoptimized/optimized + " as long as the optimized binary search ");
    }
}