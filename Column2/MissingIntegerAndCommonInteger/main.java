import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main (String args[]) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the file you want to read (with extension). Numbers.txt is available in this folder: ");
        String file = keyboard.next();
        SearchContents x = new SearchContents(new FileParser(file).readFile());
       System.out.println(x.findMissing());
       System.out.println(x.findIntThatShowsUpTwice());
       System.out.println(x.findIntThatShowsUpTwiceFaster());

    }
}
