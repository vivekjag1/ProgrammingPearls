import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * a class to read a file of integers, separated by commas, and place them into an array
 */

public class FileParser {
    String fileName; //the name of the file
    ArrayList<Integer> intList = new ArrayList<>(); //the list of integers from the file
    //constructor
    FileParser(String fileName) {
        this.fileName = fileName;
    }

    /**
     * readFile: a method to read a file and add the contents to an array
     * @return an array of integers
     * @throws IOException if the file does not exist
     */
    public ArrayList<Integer> readFile() throws IOException{
        InputStream input = this.getClass().getResourceAsStream(this.fileName); //open the file as an input stream
        if(input == null){ //if the input was null, signal that the file does not exist
            System.out.println("File does not exist!");
            System.exit(-1);
        }
        //otherwise, read the input stream
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader buff = new BufferedReader(reader);
        String line = new String();

        //while EOF has not been reached
        while ((line = buff.readLine()) != null){
            String[] words = line.split(","); //keep adding numbers to the list of integers, delimiting with a comma
            for(int i = 0; i < words.length; i++){
                String s = words[i].replace(" ", "");
                intList.add(Integer.parseInt(s));
            }
        }
        return intList;

    }


}
