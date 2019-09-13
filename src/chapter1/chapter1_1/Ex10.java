package chapter1.chapter1_1;

public class Ex10 {
  public static void main(String[] args) {
    // int[] a; 原代码无法运行，因为没有使用new为a[]分配内存。

    int[] a = new int[10]; // 更改后。
    for (int i = 0; i < 10; i++) {
      a[i] = i * i;
    }
    System.out.println(a[5]);
  }
}
