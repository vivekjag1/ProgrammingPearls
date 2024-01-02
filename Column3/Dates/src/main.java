import java.util.stream.StreamSupport;

public class main {
    public static void main(String[] args){
        Date today = new Date(1, 1, 2023);
        Date todayNextYear = new Date(1, 3, 2024);
        System.out.println(new DateCheck(todayNextYear, today).convertToDays());
        DateCheck build = new DateCheck(todayNextYear, today);
        build.buildCalendar(2, 2023);
    }
}
