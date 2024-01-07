import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * IntSetList: a class to represent a set using an integer LinkedList
 */
public class IntSetList {

    int maxSize; //size of the list
    int maxElt; //largest element
    LinkedList<Long> set = new LinkedList<>(); //set
    //constructor
    IntSetList(int maxSize, int maxElt){
        this.maxSize = maxSize;
        this.maxElt = maxElt;
    }

    /**
     * Insert: a method to insert a long into the list
     * @param toInsert an arbitrary number of longs which should be inserted
     */
    public void insert(Long ... toInsert){
        set.addAll(Arrays.asList(toInsert));
        Collections.sort(set);
    }

    /**
     * size: a method to query the size of the long set
     * @return the size
     */
    public int size(){
        return set.size();
    }

    /**
     * report: a method to print the long set
     */
    public void report(){
        Collections.sort(set);
        System.out.println(set);
    }
}
