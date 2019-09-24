package chapter1.chapter1_1;

import java.util.Arrays;

public class Ex29 {
  private static int rank(int[] a, int key) {
    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (a[mid] > key) {
        hi = mid - 1;
      } else if (a[mid] < key) {
        lo = mid + 1;
      } else {
        while (a[mid] == key) {
          mid--;
        }
        return mid + 1;
      }
    }
    return -1;
  }

  private static int count(int[] a, int key) {
    int pos = rank(a, key);
    int num = 1;
    while (a[++pos] == key) {
      ++num;
    }
    return num;
  }

  public static void main(String[] args) {
    int[] a = new int[]{84, 48, 68, 10, 18, 98, 12, 23, 54, 57, 33, 16, 77, 11, 29, 11, 29, 77, 77};
    Arrays.sort(a);


    System.out.println(rank(a, 11));
    System.out.println(count(a, 77));
  }

}
