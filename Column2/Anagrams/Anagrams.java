import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * A class to find the anagrams of a string in a given dictionary
 */

public class Anagrams {
    ArrayList<String> dictionary = new ArrayList<>();  //the dictionary (can be set with set dictionary method)
    ArrayList<String> signatures = new ArrayList<>(); //lexicographical signatures
    HashMap<String, ArrayList<String> > stringStringHashtable = new HashMap<>();
    ArrayList<ArrayList<String>> myHashTable = new ArrayList<>();
    String aString;
    Anagrams(String aString){
        this.aString = aString;
    }
    public void setDictionary(String ... strings){
        dictionary.addAll(Arrays.asList(strings));
    }

    /**
     * sortAlpha: a method to sort a string lexicographically
     * @param toSort the string sort
     * @return the sorted string
     */
    public String sortAlpha(String toSort){
        char[] charArr = toSort.toCharArray(); //convert the string to a character array
        for(int i = 0; i < toSort.length(); i++){ //iterate through the array
            for(int j = 0; j < toSort.length() - 1; j++){
                if(charArr[j] > charArr[j+1]){ //if the current character is lexicographically behind the one directly adjacent to it
                    char temp = charArr[j];
                    charArr[j] = charArr[j+1];
                    charArr[j+1] = temp;
                }
            }
        }
        signatures.add(new String(charArr)); //add all the strings to the list of signatures
        return new String(charArr); //return the lexicographically ordered string
    }

    /**
     * findAllAnagrams: a method to find all the anagrams for a particular string using a particular dictionary
     * @return a list of the anagrams
     */
    public ArrayList<String> findAllAnagrams(){
        ArrayList<String> retList = new ArrayList<>(); //will hold results
        String mySignature = sortAlpha(this.aString); //sort the target string
        String original = new String();
        for(String aString: dictionary){  //for each string in the dictionary
            original = aString; //hold the original string
            String newString = sortAlpha(aString); //get the sorted string
            if(newString.equals(mySignature)){ //if it equals the target string
                retList.add(original); //add it to the results
            }
        }
        return retList; //return results list
    }

    /**
     * fasterAnagramSearch: another method to search for anagrams of a string, but this time, the method is implemented using a hash map to make it faster
     */
    private void fasterAnagramSearch(){
        //since we are allowed pre-processing this time, set up the hash map to hold the strings
        for(String aString: dictionary){ //for every string in the dictionary, get its signature and store the original string in a list in the hash table
            if(stringStringHashtable.get(sortAlpha(aString)) == null){
                ArrayList<String> newList = new ArrayList<>();
                newList.add(aString);
                stringStringHashtable.put(sortAlpha(aString), newList );
            }
            else{
                stringStringHashtable.get(sortAlpha(aString)).add(aString);
            }
        }
    }

    /**
     * a method to hash the string and get the anagrams
     */
    public void fastAnagrams(){
        fasterAnagramSearch();//build the hash table
        System.out.println(stringStringHashtable.get(sortAlpha(this.aString))); //get the list stored at this signature
    }



}
