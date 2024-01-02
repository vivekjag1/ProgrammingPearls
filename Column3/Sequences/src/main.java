import java.util.ArrayList;

public class main {
    public static void main(String[] args){
        ArrayList<Integer> constants = new ArrayList<>();
        constants.add(2);
        constants.add(3);
        constants.add(4);
        constants.add(5);
        MySequence aSeq = new MySequence(3,constants, 0 );
        System.out.println(aSeq.solve(3));
    }
}
