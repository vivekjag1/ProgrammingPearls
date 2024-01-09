import sun.security.krb5.internal.LastReq;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * FileParser: a class to read a file and find the most common word
 */
public class FileParser {
    ArrayList<String> listOfStrings = new ArrayList<>(); //list of the strings in the file
   Hashtable<String, Integer> frequencyHashTable = new Hashtable<>(); //hash table to hold frequencies
    String fileName; //the file name

    //constructor
    FileParser(String fileName){

        this.fileName = fileName;
    }

    /**
     * readFile: a method to make an array of words included in the file
     * @return A list of strings containing the words in the file
     * @throws IOException if the file does not exist
     */
    public ArrayList<String> readFile() throws IOException {

        //open and read the file
        InputStream readerInput = this.getClass().getResourceAsStream(this.fileName);
        if(readerInput == null){
            System.out.println("File not found!");
            System.exit(-1);
        }
        InputStreamReader reader = new InputStreamReader(readerInput);
        BufferedReader buff = new BufferedReader(reader);

        String line = new String();
        String toRet = new String();
        while((line = buff.readLine()) != null){
            //split words based on spaces
            String[] words = line.split(" ");
            for(String aString: words){
                if(!listOfStrings.contains(aString)){
                    listOfStrings.add(aString);
                }
//add to the frequency table if null, update otherwise
                if(this.frequencyHashTable.get(aString) == null){
                    this.frequencyHashTable.put(aString, 1);
                }
                else{
                    this.frequencyHashTable.put(aString, this.frequencyHashTable.get(aString) + 1);
                }
            }

        }
        System.out.println(frequencyHashTable);
        return listOfStrings;
    }

    /**
     * mostCommonSubstring: a method to find the most common word in a text file
     * @return the most common word
     */
   public String mostCommonSubstring(){
        String mostCommon = new String();
        int maxFrequency  = 0;
        //iterate through, compare to the most frequent word, and update if this word is the most frequent
        for(String aString: listOfStrings){
            if(frequencyHashTable.get(aString) >maxFrequency){
                maxFrequency = frequencyHashTable.get(aString);
                mostCommon = aString;
            }

        }
        return mostCommon; //return the string accumulator
   }
}
