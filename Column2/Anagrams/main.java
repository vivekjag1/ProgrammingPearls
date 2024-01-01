public class main {
    public static void main(String args[]){

        Anagrams test = new Anagrams("deposit");
        test.setDictionary("dopiest", "posited", "topside", "hello", "world");
       test.fastAnagrams();

    }
}
