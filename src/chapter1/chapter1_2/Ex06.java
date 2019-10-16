package chapter1.chapter1_2;

/**
 * java Ex06.java abcdef cdefab
 * */
public class Ex06 {
  public static void main(String[] args) {
    String s = args[0];
    String t = args[1];

    boolean circular = (s.length() == t.length()) && (s + s).contains(t);
    System.out.println(circular ? "Yes" : "No");
  }
}
