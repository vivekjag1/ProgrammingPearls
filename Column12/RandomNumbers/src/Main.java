import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        ArrayList<String> test =new ArrayList<>();
        test.add("Vivek");
        test.add("Dad");
        test.add("Mom");
        MyRandom tester = new MyRandom(test);
        System.out.println(tester.getMRandomPrecincts(2));

        ArrayList<Integer> testIntArr = new ArrayList<>();
        testIntArr.add(5);
        testIntArr.add(4);
        testIntArr.add(3);
        testIntArr.add(2);
        testIntArr.add(1);

        System.out.println(tester.getRandomSetOfIntegersSorted(testIntArr, 23, 2));
        tester.getRandomSet(5, 30);
        System.out.println(tester.getSubsetBias(5, 5));
        System.out.println(tester.buildListOfRandomInts(4));

    }
}
