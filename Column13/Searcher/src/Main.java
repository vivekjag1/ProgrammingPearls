import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        MyRandom rando = new MyRandom(new ArrayList<>());
       BinTree master = new BinTree(5);
       master.insert(master, 6);
        master.insert(master, 4);
        master.insert(master, 7);
      // System.out.println(master.right.value);
       master.report(master);
       IntSetLin arr = new IntSetLin(4, 20);
       arr.genRandom(4, 20);
    }
}
