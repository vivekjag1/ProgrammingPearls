import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileParser file = new FileParser("Hello.txt");
        System.out.println(file.readFile());
        System.out.println(file.mostCommonSubstring());
    }
}
