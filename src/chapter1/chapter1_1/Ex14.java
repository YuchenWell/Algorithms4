package chapter1.chapter1_1;

public class Ex14 {
  public static int lg(int n) {
    int shiftRightCount = 0;
    do {
      n >>= 1;
      shiftRightCount++;
    } while (n != 0);
    return shiftRightCount - 1;
  }

  public static void main(String[] args) {
    int value = 1021;
    System.out.printf("the result of method log is :%s\r\n", lg(value));
  }
}
