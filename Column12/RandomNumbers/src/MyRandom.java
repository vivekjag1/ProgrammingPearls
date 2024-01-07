import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MyRandom {
    ArrayList<String> toRandomize;
    MyRandom(ArrayList<String> toRandomize){
        this.toRandomize = toRandomize;
    }

    /**
     * getMRandomPrecincts: a method to get m random strings from the list of strings passed into this object
     * @param m the number of strings that should be returned
     * @return a list of strings in random order
     */
    public ArrayList<String> getMRandomPrecincts(int m){
        ArrayList<String> retList = new ArrayList<>(); //the list to be returned
        int i = 0; //iterator starts at 0 to measure how many have been added
        while(i != m){
            int rando = new Random().nextInt(toRandomize.size()); //get a random integer between 0 and the number of elements in the array
            if(!retList.contains(toRandomize.get(rando))) { //if the list does not contain that integer
                retList.add(toRandomize.get(rando)); //add it
                i++; //increment
            }
        }
        return retList;//return the list of strings
    }

    /**
     * getRandomSetOfIntegersSorted: a method to get a random set of integers in sorted order
     * @param arr the array to get the set from
     * @param firstN the size of the subset to be returned
     * @param numRandom the number of random integers that the final m integers should be randonly taken from
     * @return a list of random integers in sorted order
     */
    public ArrayList<Integer> getRandomSetOfIntegersSorted(ArrayList<Integer> arr, int firstN, int numRandom){
        ArrayList<Integer> retList = new ArrayList<>(); //list to be returned
        int i = 0; //iterator
        while(i != numRandom){ //while we have not finished generating random numbers
            int rando = new Random().nextInt(arr.size());
                retList.add(arr.get(rando)); //add them all to the list
                i++;
        }

        int k = firstN;
        while(k < arr.size()){ //anything beyond the size of the requested list should be deleted
            retList.remove(firstN);
            k++;
        }
        Collections.sort(retList);//sort the list
        return retList; //return
    }

    /**
     * getRandomSet: a method to get a random set of n integers between 0 and m
     * @param numToSelect the number of integers that should be returned
     * @param numRandom the number of integers that should be considered for consideration
     */
    public void getRandomSet(int numToSelect, int numRandom){
        int select = numToSelect; //the number to select
        int remaining = numRandom; //the number to be generated
        for(int i = 0; i < numRandom; i++){
            if(new Random().nextInt(numRandom + 1) % remaining < select){ //selects randomly by:
                //first getting a random number between 0 and bound
                //stops if remaining is 0
                //randomly selects by comparing to changing constant select
                System.out.println(i); //print
                select--; //decrement the number of items to select
            }
            remaining--;//decrement the number of items to generate
        }
    }

    /**
     * getSetShuffle: a method to get a sorted set of random numbers by shuffling the original set
     * @param m the number of integers in the returned array
     * @param n the number of integers to consider
     */
   public void genSetShuffle(int m, int n){
        ArrayList<Integer> arr = new ArrayList<>();
        //build a list of n integers
        for(int i = 0; i < n; i++){
            arr.add(i);
        }

        //pick m random integers
        for(int i = 0; i < m; i++) {
            int j = ThreadLocalRandom.current().nextInt(i, n-1);

            //shuffle by swapping integers around
            int t = arr.get(i);
            arr.set(i, arr.get(j)); //move random integer to the ith position
            arr.set(j, t); //move ith integer to jth position to shuffle
        }
        //sort and print
        Collections.sort(arr);
        for(int i = 0; i < m; i++){
            System.out.println(arr.get(i));
        }
   }

    /**
     * bigRand: a method to generate a random 30 bit number
     * @return a random 30 bit number
     */
   public long bigRand(){
        long fifteenRando = new Random().nextLong(); //generate a random 15 bit number
        long nextFifteenRando = new Random().nextLong(); //get another
        fifteenRando = fifteenRando << 15; //shift the first one left by 15 bits
        fifteenRando = fifteenRando | nextFifteenRando; //non-exclusive or the two so the second attaches to the empty bits
        return fifteenRando; //return
   }

    /**
     * getSubsetBias: a method to generate a random subset that is contiguous
     * @param length the size of the subset
     * @param until the range of numbers to be considered
     * @return a contiguous subset of length n
     */
   public ArrayList<Integer> getSubsetBias(int length, int until){
       ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < length; i++){
            int rando = ThreadLocalRandom.current().nextInt(0, until); //generate random number
            for(int j = rando; arr.size() < length; j++){
                arr.add(j); //add every number from random to the size of the array
            }
        }
        return arr; //return array
   }

    /**
     * buildListOfRandomInts: a method to create a list of length len of 30 bit random integers
     * @param len the number of large integers that should be in the list
     * @return the list of random integers
     */
   public ArrayList<Long> buildListOfRandomInts(int len){
      ArrayList<Long> toRet = new ArrayList<>(); //list to be returned
        for(int i = 0; i < len; i++){ //while i less than the length
            long bigRand = this.bigRand(); //generate large integer
            if(!toRet.contains(bigRand)){ //add it to the list if it is not already in the list
                toRet.add(bigRand);
            }
            else{ //if it is in the list keep generating until we get one that is not in the list
                while(toRet.contains(bigRand = this.bigRand())){
                    bigRand = this.bigRand();
                }
                toRet.add(bigRand);
            }

        }
        return toRet;
   }
}
