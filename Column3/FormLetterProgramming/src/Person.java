import java.util.ArrayList;

/**
 * a class to represent a person and their useful information
 */
public class Person {
   ArrayList<String> info = new ArrayList<>(); //Instead of using a database, information will be stored in people objects in a hash map, and all the information will be in an arrayList
    //add all fields to this instance
    Person(String firstName, String lastName, String age, String add){
        ArrayList<String> info = new ArrayList<>();
        this.info.add(firstName);
        this.info.add(lastName);
        this.info.add(age);
        this.info.add(add);

    }

}
