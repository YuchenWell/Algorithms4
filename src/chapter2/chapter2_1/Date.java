package chapter2.chapter2_1;

public class Date {
  private final int month;
  private final int day;
  private final int year;

  public Date(int m, int d, int y) {
    month = m;
    day = d;
    year = y;
  }

  /**
   * Exercise 1.2.19
   */
  public Date(String date) {
    String[] fields = date.split("/");
    month = Integer.parseInt(fields[0]);
    day = Integer.parseInt(fields[1]);
    year = Integer.parseInt(fields[2]);
  }

  public int month() {
    return month;
  }

  public int day() {
    return day;
  }

  public int year() {
    return year;
  }

  @Override
  public String toString() {
    return month() + "/" + day() + "/" + year();
  }

}
