import java.util.ArrayList;

/**
 * PriorityQueue: a class to represent an implementation of a priority queue using a min heap
 */
public class PriorityQueue {
    int size; //number of element
     Heap aHeap = new Heap();

     //constructor
    PriorityQueue(int size){
        this.size = size;
    }

    /**
     * insert: a method to inset an element into the correct spot
     * @param anInt the integer to be inseted
     */
    public void insert(Integer anInt) {
        aHeap.insert(anInt); //insert into heap
        return;
    }

    /**
     * extractMin: a method to return the minimum element from the heap
     * @return the smallest element in the heap
     */
    public Integer extractMin(){
//        int toRet = aHeap.heap.get(1); //get smallest element
//        this.aHeap.remove(1); //remove it
//        return this.aHeap.heap.get(1); //return it
        int toRet = this.aHeap.heap.get(1);
        return toRet;
    }

    /**
     * sort: a method to implement a heap sort
     * @param toSort the list to sort
     * @return the list in sorted order
     */
    public ArrayList<Integer> sort(ArrayList<Integer> toSort){
        ArrayList<Integer> retList = new ArrayList<>();
        PriorityQueue sorter = new PriorityQueue(toSort.size());
        for(Integer anInt: toSort){
            sorter.insert(anInt); //create new priorty queue and insert all the elements into the heap
        }
        //get the minimum and remove it
        for(int i = 0; i < toSort.size(); i++){
           retList.add(sorter.extractMin()); //extract minimum element repeatidly, then remove from heap 
           sorter.aHeap.remove(1);

       }
       return retList;


    }
}
