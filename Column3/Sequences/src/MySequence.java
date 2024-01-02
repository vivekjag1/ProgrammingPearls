import java.util.ArrayList;

/**
 * a class to represent a particular user entered sequence
 */
public class MySequence {
    int degree; //number of terms in the recurrence
    ArrayList<Integer> coefficients = new ArrayList<>(); //the coefficient for each term in the recurrence
    int constant; //the initial value of the recurrence

    //constructor
    MySequence(int degree, ArrayList<Integer> coefficients, int constant){
        this.degree = degree;
        this.coefficients = coefficients;

        this.constant = constant;


    }

    /**
     * solve: takes in a number to solve for and returns the result of the sequence at that point
     * @param forWhich the input for which we want the result of
     * @return the solution
     */
    public int solve(int forWhich){
        if(forWhich == 0){ //if we hit the base case just multiply the constant by the first coefficient
            return coefficients.get(0) *constant;
        }
        else{ //otherwise return this number plus the sequence at the last
            return coefficients.get(forWhich) * (forWhich + solve(forWhich - 1));
        }
    }
}
