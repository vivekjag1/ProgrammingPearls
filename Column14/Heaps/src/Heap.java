import java.util.ArrayList;

/**
 * a class to represent a heap
 */
public class Heap {
    ArrayList<Integer> heap = new ArrayList<>(); // the heap itself

    //constructor
    Heap(){
        //heap is instantiated with new list with first element being -1 for easy access
        this.heap = new ArrayList<>();
        this.heap.add(0, -1);
    }

    /**
     * insert: a method to insert an element into the heap
     * @param toInsert the element being inserted
     */
    public void insert(Integer toInsert){
        heap.add(toInsert); //add it to the heap list
        heapifyAdd(heap.size() - 1); //rebuild the heap properties
    }

    /**
     * heapifyAdd: a method to rebuild the heap after adding an element to it
     * @param indexToMove the index that needs to be placed
     */
    private void heapifyAdd(int indexToMove){
        int justInserted = heap.get(indexToMove); //element just inserted
        int parent = heap.get(indexToMove / 2); //parent and index
        int indexParent = indexToMove / 2;
        if(justInserted <= parent && heap.get(indexParent) != -1){ //if the parent is not -1
            this.heap.set(indexParent, justInserted); //then swap the two if the child is less than the parent
            this.heap.set(indexToMove, parent);
            heapifyAdd(indexParent); //recurse to make sure no more movement is needed
        }
        else{
            return; //return if at the top
        }
    }

    /**
     * remove: a method to remove an element from a heap
     * @param toRemove the index that needs to be removed
     */
    public void remove(int toRemove){
        this.heap.remove(toRemove); //remove the element
        ArrayList<Integer> oldHeap = new ArrayList<>(this.heap); //copy over elements to a list
        this.heap = new ArrayList<>();
        heap.add(-1);
        //re do the heapify
        for(int i = 1; i < oldHeap.size(); i++){
            this.insert(oldHeap.get(i));
        }



    }

    /**
     * isHeap: a method to determine if a heap is valid
     * @param start the starting node of the heap
     * @return true iff the heap and shape properties are met
     */
    public boolean isHeap(int start){
        //get the left and right children
        int left = start * 2;
        int right = left+1;

        //if the left does not exist it must be a heap
        if(left >= heap.size()){
            return true;
        }
        //if the left exists but not the right recurse on left
        if(right >= heap.size() && left < heap.size()){
            return isHeap(left);

        }
        //otherwise, recurse on both
        if(heap.get(start) < heap.get(start * 2) && heap.get(start) < heap.get((start*2) + 1)){
            return isHeap(start*2) && isHeap((start * 2) + 1);
        }
        return false;

    }

    /**
     * siftDown: a method to re-heapify
     * @param indexToShift the index that needs to be moved
     */
    public void siftDown(int indexToShift){
        //children and indicies
        int leftChildIndex = indexToShift * 2;
        int rightChildIndex = (indexToShift * 2) + 1;
        int minChild = Math.min(heap.get(leftChildIndex), heap.get(rightChildIndex));
        int indexOfMinChild = heap.indexOf(minChild);

        //perform the swaps
        heap.set(indexOfMinChild, heap.get(indexToShift));
        heap.set(indexToShift, minChild);
        //if its a heap return, otherwise repeat
        if(isHeap(indexToShift)){
            return;
        }
        siftDown(indexOfMinChild);
    }


}
