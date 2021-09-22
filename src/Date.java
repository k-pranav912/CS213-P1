public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    //TODO add toString for date.

    public Date(String date) {  //take "mm/dd/yy" and create a Date object

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
    public Date() {} //create an object with today's date (see Calendar class)

    public boolean isValid() {
        return false;
    }

    @Override
    public int compareTo(Date date) {
        if (this.year == date.month) {
            if (this.month == date.month) {

                if (this.day == date.day) {
                    return 0;
                } else if (this.day < date.day) {
                    return -1;
                } else {
                    return 1;
                }

            } else if (this.month < date.month) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.year < date.year) {
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

}
