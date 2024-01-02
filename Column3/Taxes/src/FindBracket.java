import java.util.ArrayList;

/**
 * FindBracket: a class to search for the correct tax bracket given an income
 */
public class FindBracket {
     ArrayList<Pair> taxBrackets = new ArrayList<>(); //list of brackets with the rate and the upper bound
     int income;
     FindBracket(int income){
         //hard code in pairs
         this.income = income;
         taxBrackets.add(new Pair(0, 0.0));
         taxBrackets.add(new Pair(2700, .14));
         taxBrackets.add(new Pair(3200, .15));
         taxBrackets.add(new Pair(3700, .16));
         taxBrackets.add(new Pair(4200, .17));
     }

    /**
     * findTax: finds the amount of tax someone owes given an income
     * @return an integer representing the amount of tax
     */

     public Double findTax(){
         int myIncome = this.income;
         int index = 0;
         while (this.taxBrackets.get(index).upper < myIncome){ //searches for the first upper bound the income is less than
             index++; //increments index
         }
         return(this.taxBrackets.get(index).rate * myIncome); //return income * rate
     }


}
