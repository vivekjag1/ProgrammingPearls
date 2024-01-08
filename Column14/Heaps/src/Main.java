import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> heap = new ArrayList<>();
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);
        heap.add(6);
        heap.add(1);
        heap.add(-2);
PriorityQueue queue = new PriorityQueue(5);
        ArrayList<Integer> toSort = new ArrayList<>();
       toSort.add(2);
       toSort.add(3);
       toSort.add(1);
       toSort.add(-20495);
       toSort.add(394);
       toSort.add(-203);
       toSort.add(394);
       System.out.println(queue.sort(toSort));
    }
}
