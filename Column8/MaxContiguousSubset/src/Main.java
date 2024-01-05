import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(31);
        arr.add(-41);
        arr.add(59);
        arr.add(26);
        arr.add(-53);
        arr.add(58);
        arr.add(97);
        arr.add(-93);
        arr.add(-23);
        arr.add(84);
        FindSubset find = new FindSubset(arr);
        find.findSubsetPolynomialOne();
        find.findSubsetPolynomialTwo();
        System.out.println(find.divideAndConquerFindSubset(find.set));
        System.out.println(find.linearSearch(find.set));
    }
}
