import java.util.ArrayList;

public class Main {
    public static void main (String[] args){
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        BinarySearch runner = new BinarySearch(myList);
        System.out.println(runner.find(myList, 1));
    }
}
