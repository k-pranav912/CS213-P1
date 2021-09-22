import java.util.Calendar;

public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    public Date(String date) {  //take "mm/dd/yyyy" and create a Date object

        final int yearIndex = 6;
        final int monthStartIndex = 0;
        final int monthEndIndex = 2;
        final int dayStartIndex = 3;
        final int dayEndIndex = 5;

        assert date.length() == "mm/dd/yy".length();

        this.year = Integer.parseInt(date.substring(yearIndex));
        this.month = Integer.parseInt(date.substring(monthStartIndex, monthEndIndex));
        this.day = Integer.parseInt(date.substring(dayStartIndex, dayEndIndex));


    }
    public Date() {  //create an object with today's date (see Calendar class)
        Calendar calInstance = Calendar.getInstance();
        //System.out.println(calInstance.getTimeZone());

        this.year =  calInstance.get(Calendar.YEAR)%1000;
        //System.out.println(calInstance.get(Calendar.MONTH));
        this.month = calInstance.get(Calendar.MONTH) + 1;
        this.day = calInstance.get(Calendar.DATE);
    }

    public boolean isValid() {
        return false;
    }

    @Override
    public int compareTo(Date date) {
        if (this.year == date.month) {
            if (this.month == date.month) {

                return Integer.compare(this.day, date.day);

            //} else if (this.month < date.month) {
             //   return -1;
            } else {
                return Integer.compare(this.month, date.month);
            }
        } else if (this.year < date.year) {
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        return String.format("%02d", this.month) + "/" +
                String.format("%02d", this.day) + "/" +
                String.format("%02d", this.year);
    }

    public static void main(String[] args) {
        Date x = new Date();
        System.out.println(x);
    }

}
