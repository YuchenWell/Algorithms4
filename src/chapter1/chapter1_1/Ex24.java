package chapter1.chapter1_1;

public class Ex24 {
  public static int euclid(int a, int b) {
    System.out.println("a = " + a + ", b = " + b);

    if (a == 0 || b == 0) {
      return 1;
    }

    if (a < b) {
      int m = b;
      b = a;
      a = m;
    }

    if (a % b == 0) {
      return b;
    } else {
      return euclid(b, a % b);
    }
  }

  public static void main(String[] args) {
    int a = 50;
    int b = 120;
    int result = euclid(a, b);

    System.out.println("Result = " + result);
  }
}
