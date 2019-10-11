package chapter1.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

public class Ex23 {
  public static int rank(int key, int[] a) {
    return rank(key, a, 0, a.length - 1);
  }

  public static int rank(int key, int[] a, int lo, int hi) {
    if (lo > hi) {
      return -1;
    }

    int mid = lo + (hi - lo) / 2;
    if (key > a[mid]) {
      return rank(key, a, mid + 1, hi);
    } else if (key < a[mid]) {
      return rank(key, a, lo, mid - 1);
    } else {
      return mid;
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 6, 7, 8, 9, 12};

    System.out.print("+ or - ? ");
    char arg = StdIn.readChar();
    boolean showInWhitelist = arg == '-';

    System.out.print("Input keys: ");
    StdIn.readLine();

    String[] keys = StdIn.readLine().split(" ");
    for (int i = 0; i < keys.length; i++) {
      int key = Integer.parseInt(keys[i]);
      int pos = rank(key, a);

      if (pos != -1 && showInWhitelist) {
        System.out.printf("%s ", keys[i]);
      } else if (pos == -1 && !showInWhitelist) {
        System.out.printf("%s ", keys[i]);
      }
    }
    System.out.println();
  }
}
