public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    public Date(String date) {}
    public Date() {}

    public boolean isValid() {
        return false;
    }

    @Override
    public int compareTo(Date date) {
        return 0;
    }

}
