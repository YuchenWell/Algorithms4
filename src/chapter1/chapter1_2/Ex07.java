package chapter1.chapter1_2;

public class Ex07 {
  private static String mystery(String s) {
    int N = s.length();
    if (N <= 1) return s;
    String a = s.substring(0, N / 2);
    String b = s.substring(N / 2, N);
    return mystery(b) + mystery(a);
  }

  public static void main(String[] args) {
    String s="Yuchen";
    System.out.println(mystery(s));
  }
}
