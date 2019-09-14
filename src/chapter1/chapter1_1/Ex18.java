package chapter1.chapter1_1;

public class Ex18 {
  public static void main(String[] args) {
    System.out.println(mystery(2, 25)); // 50
    System.out.println(mystery(3, 11)); // 33
  }

  public static int mystery(int a, int b) {
    if (b == 0) {
      return 0;
    }
    if (b % 2 == 0) {
      return mystery(a + a, b / 2);
    }
    return mystery(a + a, b / 2) + a;
  }
}
