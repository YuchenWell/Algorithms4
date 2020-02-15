package chapter2.chapter2_3;


/*************************************************************************
 *  Ex 2.3.16
 *  生成不重复数组使用快速排序算法的最佳情况
 *************************************************************************/

public class Ex16 {
  public static int[] best(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = i;
    }
    best(a, 0, n - 1);
    return a;
  }

  private static int[] best(int[] a, int lo, int hi) {
    if (hi <= lo) {
      return a;
    }
    int mid = lo + (hi - lo) / 2;
    a = best(a, lo, mid - 1);
    a = best(a, mid + 1, hi);
    exch(a, lo, mid);
    return a;
  }

  private static void exch(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static void main(String[] args) {
    int count = 32;
    int[] a = best(count);
    for (int i = 0; i < count; i++) {
      System.out.print(a[i] + " ");
    }
  }
}
