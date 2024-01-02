import java.util.ArrayList;

public class main {
    public static void main (String[] args){


        Person vivek = new Person("Vivek", "Jagadeesh", "20", "REDACTED");
        Person bob = new Person("Bob", "The Builder", "200", "ALSO REDACTED");
        Schema test = new Schema(vivek, bob);
        System.out.println(test.printCorrectly("Bob"));
        test.makeFile("Vivek", "Bob");

    }
}
