import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

/**
 * A class to represent creating a file
 */
public class BuildFile {
    /**
     * createFile: creates a file with a pre-specified file name
     * @return the name of the file
     */
    public  String createFile() {
        try {
            //create the file
            File newFile = new File("personResults(8).txt");
            if (newFile.createNewFile()) {
                System.out.println("Created a file with the following name " + newFile.getName());
                return newFile.getName();

            }
            //if the file already exists signal error
            else {
                System.out.println("Error! A file with this name already exists! Delete it! Now!");
                return "";
            }
        }
        //report exception
        catch (IOException e) {
           System.exit(-1);
           return null;
        }

    }

    /**
     * write: a method to write to a file
     * @param toWrite the string to write to the file
     * @param fileName the file to write to
     */
    public void write(String toWrite, String fileName){
        try{ //open the file and write
            FileWriter writer = new FileWriter(fileName);
            writer.write(toWrite);
            writer.close();
            System.out.println("Write complete");
//report exception
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}