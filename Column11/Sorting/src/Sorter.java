import java.util.ArrayList;
import java.util.Collections;

public class Sorter {
    ArrayList<Integer> toSort = new ArrayList<>(); //the array to sort
    //constructor
    Sorter(ArrayList<Integer> toSort){
        this.toSort = toSort;
    }

// 5 4 3 2 1

    /**
     * InsertionSort: a method to perform an insertion sort
     * @return the sorted list
     */
    public ArrayList<Integer> insertionSort(){
        for(int i = 1; i < this.toSort.size(); i++){ //for every element
            int pivot = this.toSort.get(i); //the particular element
            int previous = i - 1;
            //swap adjacent elements if the element to the left is greater than the element to the right
            while(previous >= 0 && this.toSort.get(previous) > pivot){ //while there is an element to the left and it is more than the element to the right
                this.toSort.set(previous+1, this.toSort.get(previous)); //swap the two
                previous--; //decrement to move further left
            }
            this.toSort.set(previous+1, pivot);//insert the pivot into the correct position
        }
        return toSort; //return the list in sorted order
    }

    /**
     * betterInsertionSort: a method to perform an insertion sort with fewer comparisions by moving the set(pivot) statement outside the for loop
     * @return the sorted list
     */
    public ArrayList<Integer> betterInsertionSort(){
        for(int i = 0; i < this.toSort.size(); i++){ //for every element
            int pivot = this.toSort.get(i); //the pivot
            int j = i;
            while(j > 0){ //while we are not at the end of the list
                if(toSort.get(j-1) < pivot){ //if the element to the left of the pivot is smaller than it, then do nothing
                    break;
                }
                //otherwise, set the pivot position to the item to the left
                    this.toSort.set(j, this.toSort.get(j-1));

                j--;
            }
            //set the pivot to be in its correct position when completed
            toSort.set(j, pivot);
        }
        return toSort;
    }

    /**
     * quickSort: a method to sort an array using a quick sort algorithim
     * @param arr the array to sort
     * @return the sorted list
     */
    public ArrayList<Integer> quickSort(ArrayList<Integer> arr){
        if(arr.size() <= 1){ //if the array is 1 or fewer elements just return
            return arr;
        }
        else{
            //randomize and pick the head to get the median as the head (hopefully)
            Collections.shuffle(arr);
            int pivot = arr.get(0);
            //split into two arrays - everything less than the pivot goes to the left, everything greater than goes to the right
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            for(int i = 0; i < arr.size(); i++){
                if(arr.get(i) == pivot){
                    continue;
                }
                else if(arr.get(i) < pivot){
                    left.add(arr.get(i));
                }
                else{
                    right.add(arr.get(i));
                }
            }
            //then sort each sub-half recursively and merge everything back together
            return merge(quickSort(left), quickSort(right), pivot);

        }
    }

    /**
     * merge: a method to merge 2 lists and an integer together
     * @param left the left half of the final list
     * @param right the right half of the final list
     * @param pivot the pivot to be put in the middle
     * @return the merged list with the following form: left pivot right 
     */
    public ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right, int pivot){
        ArrayList<Integer> retList = new ArrayList<>(left);
        retList.add(pivot);
        retList.addAll(right);
        return retList;


    }
}
