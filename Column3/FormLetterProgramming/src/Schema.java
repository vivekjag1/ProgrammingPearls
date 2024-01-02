import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * a class to interpret a Form Letter String using a pre-defined schema:
 * 0  = first name
 * 1 = last name
 * 2 = age
 * 3 = address
 */
public class Schema {
   final String toPrint = "Welcome back $1, $0! We hope that you are enjoying your year at age $2 living at $3!"; //string
    Hashtable<String, Person> people = new Hashtable<>(); //hash table to store Person objects
    Person aPerson; //a person
    //add all people to the hash table
   Schema(Person ...aPerson){
       for(Person person: aPerson){
           people.put(person.info.get(0), person);
       }

   }

    /**
     * printCorrectly: a method to fill in the string according to the schema
     * @param whichPerson the person whos information should be filled into the string
     * @return the string above with information rather than placeholders
     */
   public StringBuilder printCorrectly(String whichPerson){
       Person thisPerson = people.get(whichPerson); //get the person from the hash table
       StringBuilder retString = new StringBuilder(new String());
       for(int i = 0; i < toPrint.length(); i++){ //iterate through characters

           //print non-'$' characters as usual
           if(toPrint.charAt(i) != '$'){
               retString.append(toPrint.charAt(i));
           }
           else{
               //otherwise get the index of the placeholder
              int digit = Character.getNumericValue(toPrint.charAt(i + 1));
              //add it to the string
              retString.append(thisPerson.info.get(digit));
              i++;//skip the digit since we just updated the placeholder.

           }
       }
       return retString; //return the string


   }

    /**
     * makeFile: a method to build a file with the information of the specified people
     * @param whichPerson the people whos information should be in the file
     */
   public void makeFile(String ...whichPerson){
       boolean firstFlag = true;
       ArrayList<String > toRet = new ArrayList<>();
       for (String str: whichPerson){ //add all the people to an array
           StringBuilder ret = printCorrectly(str);
           toRet.add(String.valueOf(ret));

       }
       //next create a file
       BuildFile file = new BuildFile();
       String name = new String();
       for(String aString: toRet){ //if this is being called the first time, create the file

           if(firstFlag){
               firstFlag = false;
                name = file.createFile();
               file.write(String.valueOf(aString), name);
           }
           else{ //otherwise append to existing file
               try{
                   FileWriter aWriter = new FileWriter(name, true);
                   BufferedWriter buff = new BufferedWriter(aWriter);
                   PrintWriter printWriter = new PrintWriter(buff);
                   printWriter.println();
                   printWriter.println(aString);
                   printWriter.flush();

                   aWriter.close();
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }

           }

       }


   }

}
