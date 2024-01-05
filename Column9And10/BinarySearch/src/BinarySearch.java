import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
    ArrayList<Integer> list = new ArrayList<>();
    //constructor
    BinarySearch(ArrayList<Integer> list){
        this.list = list;
    }

    /**
     * find: the user interface for the binary search that hides parameters that always need to be set to 0 initally
     * @param toSearch the list to search
     * @param whichNum the number we are looking for
     * @return the index of the target
     */
    public int find(ArrayList<Integer> toSearch, int whichNum){
        return binSearch(toSearch, whichNum, 0, 0);
    }
    public int findFast(ArrayList<Integer> toSearch, int whichNum){
        return binSearchFast(toSearch, whichNum, 0, 0);
    }

    /**
     * binSearch: a method to search for an element by recursively splitting the list in half
     * @param toSearch the list to search
     * @param whichNum the number to search for
     * @param index the index counter (always starts at zero)
     * @param numComparisons the number of comparisons counter (always starts at zero)
     * @return the index of the number we are searching for
     */
    private int binSearch(ArrayList<Integer> toSearch, int whichNum, int index, int numComparisons){
        Collections.sort(toSearch); //make sure the list is sorted
        if(toSearch.size() ==1){ //if the array is just one element
            System.out.println("Comparisons" + numComparisons); //return the number of comparisons and index
            return index;
        }
        else{
            //otherwise get the midpoint
            int mid = toSearch.size() / 2;
            int value = toSearch.get(mid);

            numComparisons++;
            if(value > whichNum){ //if the midpoint is greater than the target, the target is to the left

                //create left half and recurse
                ArrayList<Integer> left = new ArrayList<>();
                for(int i = 0; i < mid; i++){
                    left.add(toSearch.get(i));
                }
                return binSearch(left, whichNum, index, numComparisons);
            }
            else{
                //otherwise it is to the right

                //create right half and recurse
                ArrayList<Integer> right = new ArrayList<>();
                for(int i = mid; i < toSearch.size(); i++){
                    right.add(toSearch.get(i));
                }
                index+= right.size();
                return binSearch(right, whichNum, index, numComparisons);
            }
        }

    }

    /**
     * binSearchFast: a faster binary search method
     * Speed up enabled by
     * 1. use of re-calculation instead of variables
     * 2. use of bit shifting instead of division
     * @param toSearch the array to search
     * @param whichNum the number to search for
     * @param index the index (starts at 0)
     * @param numComparisons the counter for the number of comparisons (starts at zero)
     * @return the position of the desired number
     */
    private int binSearchFast(ArrayList<Integer> toSearch, int whichNum, int index, int numComparisons){
        Collections.sort(toSearch); //make sure the list is sorted
        if(toSearch.size() ==1){ //if the array is just one element
            System.out.println("Comparisons" + numComparisons); //return the number of comparisons and index
            return index;
        }
        else{
            //otherwise get the midpoint
            numComparisons++;
            if(toSearch.get((toSearch.size()) >> 1) > whichNum){ //if the midpoint is greater than the target, the target is to the left

                //create left half and recurse
                ArrayList<Integer> left = new ArrayList<>();
                for(int i = 0; i < (toSearch.size()) >> 1; i++){
                    left.add(toSearch.get(i));
                }
                return binSearchFast(left, whichNum, index, numComparisons);
            }
            else{
                //otherwise it is to the right

                //create right half and recurse
                ArrayList<Integer> right = new ArrayList<>();
                for(int i = (toSearch.size()) >> 1 ; i < toSearch.size(); i++){
                    right.add(toSearch.get(i));
                }
                index+= right.size();
                return binSearchFast(right, whichNum, index, numComparisons);
            }
        }

    }

}