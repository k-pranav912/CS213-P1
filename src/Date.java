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

        assert date.length() == "mm/dd/yyyy".length();

        this.year = Integer.parseInt(date.substring(yearIndex));
        this.month = Integer.parseInt(date.substring(monthStartIndex, monthEndIndex));
        this.day = Integer.parseInt(date.substring(dayStartIndex, dayEndIndex));


    }
    public Date() {  //create an object with today's date (see Calendar class)
        Calendar calInstance = Calendar.getInstance();
        //System.out.println(calInstance.getTimeZone());

        this.year =  calInstance.get(Calendar.YEAR);
        this.month = calInstance.get(Calendar.MONTH) + 1;
        this.day = calInstance.get(Calendar.DATE);
    }

    private static boolean isLeap(Date date) {

        final int QUADRENNIAL = 4;
        final int CENTENNIAL = 100;
        final int QUATERCENTENNIAL = 400;
        final int start = 0;

        switch (start) {

            case 0: if (!(date.year % QUADRENNIAL == 0)) return false;

            case 1: if (!(date.year % CENTENNIAL == 0)) return true;

            case 2: if (!(date.year % QUATERCENTENNIAL == 0)) {
                        return false;
                    } else return true;

        }

        return false;
    }

    public boolean isValid() {
        return false;
    }

    @Override
    public int compareTo(Date date) {
        if (this.year == date.year) {
            if (this.month == date.month) {
                return Integer.compare(this.day, date.day);
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
                String.format("%04d", this.year);
    }

    public static void main(String[] args) {
        Date x = new Date("08/31/2010");
        Date y = new Date ("08/31/2001");
        System.out.println(x);
        System.out.println(y);
        System.out.println(x.compareTo(y));
    }

}
