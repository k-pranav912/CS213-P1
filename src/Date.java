import java.util.Calendar;

public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    private static final int QUADRENNIAL = 4;
    private static final int CENTENNIAL = 100;
    private static final int QUATERCENTENNIAL = 400;

    private static final int[] thirtyOneMonths = {1,3,5,7,8,10,12};
    private static final int maxMonths = 12;
    private static final int febMonth = 2;
    private static final int thirtyOneDays = 31;
    private static final int thirtyDays = 30;
    private static final int febNonLeapDays = 28;
    private static final int febLeapDays = 29;
    private static final int minYear = 1980;

    public Date(String date) {
        String[] tokens = date.split("/");

        this.year = Integer.parseInt(tokens[2]);
        this.month = Integer.parseInt(tokens[0]);
        this.day = Integer.parseInt(tokens[1]);

    }

    public Date() {  //create an object with today's date (see Calendar class)
        Calendar calInstance = Calendar.getInstance();

        this.year =  calInstance.get(Calendar.YEAR);
        this.month = calInstance.get(Calendar.MONTH) + 1;
        this.day = calInstance.get(Calendar.DATE);
    }

    private static boolean isLeap(Date date) {

        int start = 0;

        switch (start) {

            case 0: if (!(date.year % QUADRENNIAL == 0)) return false;

            case 1: if (!(date.year % CENTENNIAL == 0)) return true;

            case 2: if (!(date.year % QUATERCENTENNIAL == 0)) {
                        return false;
                    } else return true;

        }

        return false;
    }

    private static boolean check(int[] arr, int key) {

        for (int j : arr) {
            if (j == key) return true;
        }

        return false;

    }

    public boolean isValid() {
        if (this.year < minYear) return false;
        if (this.month <= 0 || this.day <= 0) return false;
        if (this.month > maxMonths) return false;

        Date tempDate = new Date();
        if (this.compareTo(tempDate) == 1) return false;

        if (this.month == febMonth) {
            if (isLeap(this)) {
                return (this.day <= febLeapDays);
            } else {
                return (this.day <= febNonLeapDays);
            }
        }

        if (check(thirtyOneMonths, this.month)) {
            return (this.day <= thirtyOneDays);
        } else {
            return this.day <= thirtyDays;
        }

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

    /*
    @Override
    public String toString() {
        return String.format("%02d", this.month) + "/" +
                String.format("%02d", this.day) + "/" +
                String.format("%04d", this.year);
    }
    */

    @Override
    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    public int getDateIndex() {
        return (this.year * 10000) + (this.month * 100) + (this.day);
    }

    public static void main(String[] args) {

        // Test 1
        // valid date
        Date test1 = new Date("08/31/2000");
        System.out.println(test1);
        if (test1.isValid()) {
            //System.out.println(test1.getDateIndex());
            System.out.println("Test1: Valid Date!");
        } else {
            System.out.println("Test1: Invalid Date!");
        }

        Date test2 = new Date();
        if (test2.isValid()) {
            System.out.println("Test2: Valid Date!");
        } else {
            System.out.println("Test2: Invalid Date!");
        }

        Date test3 = new Date("08/31/1979");
        if (test3.isValid()) {
            System.out.println("Test3: Valid Date!");
        } else {
            System.out.println("Test3: Invalid Date!");
        }

    }

    public static void main2(String[] args) {
        /*
        Date x = new Date("02/29/2001");
        Date y = new Date ("08/31/2001");
        Date z = new Date();
        System.out.println(x);
        System.out.println(y);
        System.out.println(x.compareTo(z));
        System.out.println(x.isValid());
        */

        // Test 1
        // valid date
        try {
            Date test1 = new Date("08/31/2000");
            System.out.println("Test1: Valid Date!");
        }   catch (AssertionError e) {
            System.out.println("Test1: Invalid Date!");
        }

        // Test 2
        //valid date with Calendar
        try {
            Date test2 = new Date();
            System.out.println("Test2: Valid Date!");
        }   catch (AssertionError e) {
            System.out.println("Test2: Invalid Date!");
        }

        // Test 3
        // invalid date format
        try {
            Date test3 = new Date("");
            System.out.println("Test3: Valid Date!");
        }   catch (AssertionError e) {
            System.out.println("Test3: Invalid Date!");
        }

        // Test 4
        // Year less than 1980
        try {
            Date test4 = new Date("08/31/1979");
            System.out.println("Test4: Valid Date!");
        }   catch (AssertionError e) {
            System.out.println("Test4: Invalid Date!");
        }

        // Test 5
        // Invalid month (<= 0)
        try {
            Date test5 = new Date("00/31/2000");
            System.out.println("Test5: Valid Date!");
        }   catch (AssertionError e) {
            System.out.println("Test5: Invalid Date!");
        }

        // Test 6
        // Invalid month (> 12)
        try {
            Date test6 = new Date("13/31/2000");
            System.out.println("Test6: Valid Date!");
        }   catch (AssertionError e) {
            System.out.println("Test6: Invalid Date!");
        }

        // Test 7
        // Invalid day (<= 0)
        try {
            Date test7 = new Date("08/00/2000");
            System.out.println("Test7: Valid Date!");
        }   catch (AssertionError e) {
            System.out.println("Test7: Invalid Date!");
        }

        //Test 8
        // Invalid day (> 31)
        try {
            Date test8 = new Date("08/32/2000");
            System.out.println("Test8: Valid Date!");
        }   catch (AssertionError e) {
            System.out.println("Test8: Invalid Date!");
        }

        //Test 9
        // Invalid date (> Current Calendar Date)
        try {
            Date test9 = new Date("08/31/2023");
            System.out.println("Test9: Valid Date!");
        }   catch (AssertionError e) {
            System.out.println("Test9: Invalid Date!");
        }

        //Test 10
        // Invalid Feb date (>28 on non-Leap Year)
        try {
            Date test10 = new Date("02/29/2001");
            System.out.println("Test10: Valid Date!");
        }   catch (AssertionError e) {
            System.out.println("Test10: Invalid Date!");
        }

        //Test 11
        // Invalid date (>31 in April)
        try {
            Date test11 = new Date("04/31/2000");
            System.out.println("Test11: Valid Date!");
        }   catch (AssertionError e) {
            System.out.println("Test11: Invalid Date!");
        }

    }

}
