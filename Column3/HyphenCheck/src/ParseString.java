import java.util.ArrayList;
import java.util.Arrays;

public class ParseString {
    String toCheck; //the string to check against
    ArrayList<String> legals = new ArrayList<>(); //list of legal hype position
    //constructor
    ParseString(String toCheck){
        this.toCheck = toCheck;
        //set all legal hyphen positions
       addAll("et-ic", "al-is-tic", "p-tic", "-lyt-ic", "ot-ic", "an-tic", "n-tic", "c-tic", "at-ic", "h-nic",
               "n-ic", "m-ic", "l-lic", "b-lic", "-clic", "l-ic", "h-ic", "f-ic", "d-ic", "-bic", "a-ic", "mac i-ac");



    }

    /**
     * addAll: a method to add an unspecified number of strings to a list of strings
     * @param aString the strings to add
     */
    public void addAll(String ...aString){
        legals.addAll(Arrays.asList(aString));
    }

    /**
     * search: a method to search for a legally positioned hyphen in a string
     * @param aString the string to search
     * @return true iff there is a hyphen in a legal position in the string
     */
    public boolean search(String aString){
        boolean legal = false;
        for(String str: legals){
            if (aString.contains(str)){ //if the string contains any of the legal hyphens
                legal = true; //return true
            }
        }
        return legal; //else return false
    }

    /**
     * check: a method to determine if a word is legal
     * @param aString the word to check
     * @return true iff it either has a hyphen in a legal spot or does not need a hypen
     */
    public boolean check(String aString){

        return search(aString) || !checkIfItShouldHaveHadAHyphen(aString);
    }

    /**
     * checkIfItShouldHaveHadAHyphen: a method to check if a hyphen-less word needs one
     * @param aString the word to check
     * @return true iff the word is missing a hyphen in a position it should have one
     */
    public boolean checkIfItShouldHaveHadAHyphen(String aString){
        for(int i = 0; i < aString.length(); i++){
            String checker = new String();
            checker = checker + aString.substring(0, i) + "-" + aString.substring(i);
            if(search(checker)){
                return true;
            }

        }
        return false;
    }

}
