import java.util.ArrayList;

/**
 * DateCheck: a class to perform operations on dates
 */
public class DateCheck {
    //the dates to compare
    Date dateOne;
    Date dateTwo;
    ArrayList<Integer> days = new ArrayList<>();
//constructor hard codes in days in year
    DateCheck(Date dateOne, Date dateTwo){
        addAll(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
        this.dateOne = dateOne;
        this.dateTwo = dateTwo;
    }

    /**
     * convertToDays: converts two dates into days
     * @return the number of days between the two dates
     */

    public int convertToDays(){
        int monthInDaysDateOne = this.days.get(dateOne.month - 1); //converts the month to the correct number of days
        int monthInDaysDateTwo = this.days.get(dateTwo.month - 1);
        int yearOne = 365;
        int yearTwo = 365;
        //checks if either year is a leap year
        if (dateOne.year % 4 == 0){
            yearOne = 366;
        }
        if (dateTwo.year % 4 == 0){
            yearTwo = 366;
        }
        //finds the difference in days per year
        int yearDiff = (this.dateTwo.year - this.dateOne.year) * findDays(this.dateTwo.year, this.dateOne.year);
        return Math.abs(((monthInDaysDateOne + dateOne.day) - (monthInDaysDateTwo + dateTwo.day))) + Math.abs(yearDiff);
        //return the number of days between the month + days + year difference

    }

    /**
     * findDays: a method to find the number of days that occur  in the greater of the two years
     * @param yearOne the first year
     * @param yearTwo the second year
     * @return the number of days in the greater of the two years
     */
    public int findDays(int yearOne, int yearTwo){
        int max = Math.max(yearOne, yearTwo); //find the greater year
        if(max % 4 == 0){ //if the greater year is a leap year
            return 366; //there are 366 days
        }
        else{ //otherwise there are 365
            return 365;
        }
    }
    public void addAll(int ... ints){
        for(int anInt: ints){
            days.add(anInt);
        }
    }

    /**
     * buildCalender: a method to print a calendar for a particular month
     * @param whichMonth the month to print the calendar for
     * @param whichYear the year the month occurs in
     */
    public void buildCalendar(int whichMonth, int whichYear){
        ArrayList<Integer> days = new ArrayList<>();
        int numDays = this.days.get(whichMonth - 1); //get the number of days from the arra y
        if(whichYear % 4 == 0&& whichMonth == 2){ //if its febuary in a leap year
            numDays++;//add a day
        }
        for(int i = 0; i <=numDays; i++){ //print all the days in an array
            days.add(i);
        }
        System.out.println(days); //print the array
    }
}
