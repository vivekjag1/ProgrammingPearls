import java.util.ArrayList;
public class FindSubset {
    ArrayList<Integer> set; //the set for which we want to find the maximum contiguous subset
    //constructor
    FindSubset(ArrayList<Integer> set){
        this.set = set;
    }

    /**
     * findSubsetPolynomialOne: a method to find the largest contiguous subset in polynomial time
     * does this by finding every contiguous subset following each element and picks the largest
     */
    public void findSubsetPolynomialOne(){
        //counters that will be printed
        int allTimeSum = 0;
        int startingIndex = 0;
        int endingIndex = 0;

        //use every element as a pivot
        for(int i = 0; i < this.set.size(); i++){
            int mySum = this.set.get(i);
            for(int j = i + 1; j < this.set.size(); j++){
                //add the jth element adjacent to the pivot to the sum
               mySum+= this.set.get(j);
                //if its greater than the current sum, update it, otherwise continue on
               if(mySum > allTimeSum){
                   allTimeSum = mySum;
                   startingIndex = i;
                   endingIndex = j;
               }
            }
        }
        System.out.println("The sum is: " + allTimeSum + " and it starts at index: " + startingIndex + " and ends at index: " + endingIndex);
    }

    /**
     * findSubsetPolynomialTwo: a second method to find the largest contiguous subset in the set in polynomial time
     * does this by creating a list of sums and adding each element to the previous sum iff it is better
     */
    public void findSubsetPolynomialTwo(){
        ArrayList<Integer> sums = new ArrayList<>(); //list of sums

        //start counters
        int allTimeSum = 0;
        int start = 0;
        int end = 0;

        //for every element
        for (int i = 0; i < this.set.size(); i++){
            //for the first element just add the first element
            if(i == 0){
                sums.add(this.set.get(i));
            }
            //otherwise add the element plus the previous sum
            else{
                sums.add(sums.get(i -1) + this.set.get(i));
            }
        }
        //then for every element in sums
        for(int i = 0; i < this.set.size(); i++){
            int sum = 0;
            //the sum is 0 if it's the first element
            for(int j = i + 1;  j < this.set.size(); j++){
                if (i == 0){
                    sum = sums.get(j)  ;
                }
                //otherwise the sum of the contiguous subset is the sum at j minus the sum at i - 1
                else{
                    sum = sums.get(j)  -  sums.get(i-1);

                }
                //update counters if necessary
                if (sum > allTimeSum){
                    allTimeSum = sum;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println("The sum is: " + allTimeSum + " and it starts at index: " + start + " and ends at index: " + end);

    }

    /**
     * divideAndConquerFindSubset: a method to find the largest contiguous subset in linearithmic (n log n) time
     * @param arr the array to search
     * @return the best sum of contiguous elements
     */
    public int divideAndConquerFindSubset(ArrayList<Integer> arr){
        if(arr.size() == 1){ //if the array size is 1, then the maximum is either 0 or the head of the list
            return findLargest(0, arr.get(0));
        }
        else if (arr.size() == 0){ //if the array is empty the maximum is 0
            return 0;
        }
        //otherwise:
        else{
            //break the array into halves
            int mid = arr.size() / 2;
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            for(int i = 0; i < mid; i++){
                left.add(arr.get(i));
            }
            for(int i = mid; i < arr.size(); i++){
                right.add(arr.get(i));
            }
            //find best sequence in the right and left
            int mySum = 0;
            int lSum = 0;

            //count from the right to left for the left sub-half so that the right and left when put together form a sequence
            for(int i = left.size() - 1; i >= 0; i--){
                mySum += left.get(i);
                lSum = findLargest(lSum, mySum);
            }

            mySum = 0;
            int rSum = 0;
            //go the opposite way for the right sub-half
            for(int i = 0; i < right.size(); i++){
                mySum += right.get(i);
                rSum = findLargest(rSum, mySum);
            }
            //return either the sum of the sub-halfs, or the best contiguous sum in either half
            return findLargest((lSum + rSum), divideAndConquerFindSubset(left), divideAndConquerFindSubset(right));
        }
    }

    /**
     * findLargest: a method to find the largest element in the input
     * @param ints an aribitrary amount of integers
     * @return the largest integers out of those inputted
     */
    public int findLargest(Integer ... ints){
        int max = 0; //start max at 0
        for(Integer anInt: ints){ //if an integer is greater than the max set it
            if (anInt > max){
                max = anInt;
            }
        }
        return max;
    }

    /**
     * linearSearch: a method to find the greatest contiguous subset in linear time
     * @param arr the array to search
     * @return an integer representing the sum of the greatest contiguous subset
     */
    public int linearSearch(ArrayList<Integer> arr){
        //start counters at 0
        int sum = 0;
        int max = 0;
        for (Integer anInt: arr){
            //for every element, if the sum improves as a result of taking the next element, take those integers, otherwise stop at the current subset
            sum = findLargest(sum + anInt, 0);
            max = findLargest(sum, max);
        }
        return max; //return largest sum
    }
}
