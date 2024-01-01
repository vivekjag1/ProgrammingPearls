import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * SearchContents: a class to search through the contents of a file for useful information
 */
public class SearchContents {
    ArrayList<Integer> fromFile; //the array of integers from the file
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    //constructor
    SearchContents(ArrayList<Integer> fromFile){
        this.fromFile = fromFile;
    }

    /**
     * isCorrectSequence: a method to determine if a sequence of numbers is legitimate
     * @param arr the sequence
     * @return true iff the numbers follow each other by one
     */
    public boolean isCorrectSequence(ArrayList<Integer> arr) {
        Collections.sort(arr); //sort the sequence
        return ((arr.size() - 1) + (arr.get(0)) == arr.get(arr.size() - 1)) && !hasDuplicate(); //check that there are no duplicates and that the last entry - first entry = size -1
    }

    /**
     * hasDuplicate: a method to determine if a sequence has a number appear more than once
     * @return true iff a number exists more than once.
     */
    boolean hasDuplicate(){
        //for every item in the list search the rest of the list for another instance of the item
       for(int i = 0; i < this.fromFile.size(); i++){
           for(int j = i +1; j < this.fromFile.size(); j++){
               if(this.fromFile.get(i) == this.fromFile.get(j)){
                   return true;
               }
           }
       }
       return false;
    }

    /**
     * findMissing: a method to find a missing number from a file of random integers
     * @return a list of missing integers
     */
    ArrayList<Integer> findMissing(){
        return split(this.fromFile);

    }

    /**
     * split: a method to do a binary search of a file to find an integer not present
     * @param arr
     * @return
     */
    public ArrayList<Integer> split(ArrayList<Integer> arr){
        if(arr.size() <= 2){ //base case is when we have isolated the missing integer to be between two numbers or directly after a number
            return fill(arr);
        }
        else{
            //split the array in half
            ArrayList<Integer> left = new ArrayList<>();
            for(int i = 0; i < arr.size() / 2; i++){
                left.add(arr.get(i));
            }
            ArrayList<Integer> right = new ArrayList<>();
            for(int i = arr.size()/2; i < arr.size(); i++){
                right.add(arr.get(i));
            }

            //recursively split that half if it is not a correct sequence
            if(!isCorrectSequence(left)){
                return split(left);
            }
            else if(!isCorrectSequence(right)){
                return split(right);
            }
            //if both are correct, then split the smaller of the two
            else{
                if (right.size() < left.size()){
                    return split(right);
                }
                else if (left.size() < right.size()){
                    return split(left);
                }
                //if both are correct and the same size then the non-existant integer must occur in the numbers between the two, so add the last int of the left and first of the right and recurse
                else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(left.get(left.size() - 1));
                    list.add(right.get(right.size() - 1));
                    return split(list);
                }
            }
        }
    }

    /**
     * fill: a method to find the missing integer once the position is identified
     * @param arr the array with the missing integer
     * @return an array of missing integers
     */
    public ArrayList<Integer> fill(ArrayList<Integer> arr){
        ArrayList<Integer> toRet = new ArrayList<>(); //the list to return
        int start = arr.get(0);
        int end = arr.get(arr.size() - 1);
        int index = 0;
        do{ //add one added to the head of the list, since this is only called in the base case that the missing number is in between two numbers or is greater than one number
            toRet.add(++start);
            index++; //increment index
            if(index == arr.size()){ //if we reached the end of the array
                break;
            }

        }
        while (arr.get(index) != arr.size()); //continue as long as there are missing numbers

        return toRet;
    }

    /**
     * findMax: a method to find the largest element in an array
     * @param arr the array to search
     * @return the largest element in that array
     */
    public int findMax(ArrayList<Integer> arr){
        int max = 0; //start counter at zero
        for(int anInt: arr){ //update if we find an element larger than the counter
            if(anInt > max){
                max = anInt;
            }
        }
        return max; //return counter
    }

    /**
     * findIntThatShowsUpTwice: a method to find an integer that appears twice in a file
     * @return a list of integers that appear more than once in the file
     */
    public ArrayList<Integer> findIntThatShowsUpTwice(){
        ArrayList<Integer> retList = new ArrayList<>(); //list to be returned
        ArrayList<ArrayList<Integer>> intLists = new ArrayList<>(); //list of integer frequencies in the original files
        //set the list
        for(int i = 0; i <= findMax(fromFile); i++){ //create n entries where n is the maximum entry
            intLists.add(new ArrayList<>());
        }
        for(int anInt: fromFile){ //then add each integer as many times as they appear in the file
            intLists.get(anInt).add(anInt);
        }
        for(ArrayList<Integer> aList : intLists){ //then go through the list just created, and return the indicies with multiple entries
            if(aList.size() > 1){
                retList.add(aList.get(0));
            }
        }
        return retList;

    }

    /**
     * findIntThatShowsUpTwiceFaster: a faster method of finding the integers which appear multiple times using a hashmap
     * @return the list of integers that appear more than once
     */

    public ArrayList<Integer> findIntThatShowsUpTwiceFaster(){
        ArrayList<Integer> retList = new ArrayList<>(); //list of integers to return
        ArrayList<Integer> uniques = new ArrayList<>(); //input list without duplicated
        //set the list
        for(int anInt: fromFile){ //for every integer

            //if its not the first time the element has been seen increment frequency in hash table
            if( hashMap.get(anInt) != null) {
                int oldValue = hashMap.get(anInt);
                hashMap.put(anInt, ++oldValue);
            }
            //otherwise set frequency to 1
            else{
                //increment the freuqnece
                hashMap.put(anInt, 1);
                uniques.add(anInt);
            }
        }
        //then for every element, see what its value is for its key
      for(int anInt: uniques){
          //if its more than one it appeared multiple times, add it to the return list
          if(hashMap.get(anInt) > 1){
              retList.add(anInt);
          }
      }
        return retList;

    }
}
