import java.util.ArrayList;
import java.util.Arrays;

/**
 * IntSetLin: a class to implement a set of integers with an integer array
 */
public class IntSetLin {

    int maxSize; //the number of longs
    int maxElt; //size of largest element
    Long[] set = new Long[maxSize + 1]; //set
    //constructor
    IntSetLin(int maxSize, int maxElt){
        this.maxSize = maxSize;
        this.maxElt = maxElt;
    }

    /**
     * insert: a method to add an unspecified number of longs to the set
     * @param toInsert the longs to insert
     */
    public void insert(Long ... toInsert){
        for(Long aLong: toInsert){
            set[set.length - 1] = aLong;
        }
        Arrays.sort(set);
    }

    /**
     * size: a method to query the size of the set
     * @return the size of the set
     */
    public int size(){
        return set.length;
    }

    /**
     * report: a method to print the set
     */
    public void report(){
        Arrays.sort(set);
        System.out.println(Arrays.toString(set));
    }

    /**
     * has: a method to determine if a particular element is in the set
     * @param target the element to search for
     * @return true iff the element is in the set
     */
    public boolean has(long target){
        try{ //try to search for the element, return true if it is in the list
            for(int i = 0; i < this.set.length; i++){
                if(this.set[i] == target){
                    return true;
                }
            }

        }
        catch (NullPointerException e){ //if the list was empty just return false
            return false;
        }

        return false;
    }

    /**
     * genRandom: a method to generate a random set of integers using a set
     * @param length the length the set should be
     * @param until the range for random integers
     */
    public void genRandom(int length, int until){
        IntSetLin s = new IntSetLin(length, until);
        for(int i = until - length; i < until; i++){
            long t = new MyRandom(new ArrayList<>()).bigRand() % (i+1); //method for generating random number
            if(!s.has(t)){ //if its not in the array inset
                s.insert(t);
            }
            else{ //if it is in the array insert the index
                s.insert((long) i);
            }
            s.report();//print the array
        }
    }
}
