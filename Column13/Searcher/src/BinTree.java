/**
 * BinTree: A class to represent a binary search tree
 */
public class BinTree {
    int value; //the value of the current node
    BinTree left; //left and right nodes
    BinTree right;
    //constructor
    BinTree(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * insert: a method to insert a new node into a binary tree recursively
     * @param tree the tree to search
     * @param valueToInsert the value to insert
     */
    public void insert(BinTree tree, int valueToInsert){
        if(valueToInsert > tree.value && tree.right == null){ //if the right branch is a leaf and the value is greater than the node
            tree.right = new BinTree(valueToInsert); //create the right branch with the node value being the value we want to insert
        }
        else if(valueToInsert < tree.value && tree.left == null){ //if the left branch is a leaf and the value is less than the node
            tree.left = new BinTree(valueToInsert); //create the left branch with the node value being the value we want to insert
        }
        else{
            if(valueToInsert > tree.value){ //if the value is greater than the value and the right exists, recurse on the right
                insert(tree.right, valueToInsert);
            }
            else{//if the value is less than the value and the left exists, recurse on the left
                insert(tree.left, valueToInsert);
            }
        }
    }

    /**
     * report: a method to print a binary tree
     * @param tree the tree to print
     */
    public void report(BinTree tree){
        System.out.println("Node: " + tree.value); //print out the node value
        if(tree.right == null && tree.left == null){ //if both are null just return
            return;
        }
        else{ //otherwise recurse and print the correct branch being entered
            if(!(tree.left == null)){
                System.out.println("Entering the left of node: " + tree.value);
                report(tree.left);
            }
            if(!(tree.right == null)){
                System.out.println("Entering the right of node: " + tree.value);
                report(tree.right);
            }
        }


    }

}
