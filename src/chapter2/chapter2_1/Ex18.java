package chapter2.chapter2_1;

import edu.princeton.cs.algs4.In;

/**
 * Exercise 2.1.18
 * 排序可是轨迹
 */
public class Ex18 {
  public static void main(String[] args) {
    /*
     * 用来排序的文件
     * - tiny.txt ```S O R T E X A M P L E```
     * - words3.txt
     */
    String filename = "algs4-data/tiny.txt";
    String[] a = new In(filename).readAllStrings();

    String alg = "Selection"; // Selection | Insertion
    if (alg.equals("Selection")) {
      Selection.drawSort(a);
    } else if (alg.equals("Insertion")) {
      Insertion.drawSort(a);
    } else if (alg.equals("Shell")) {
      Insertion.drawSort(a);
    }

  }
}
