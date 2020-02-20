package chapter2.chapter2_5;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class Frequency {
  public static void main(String[] args) {
    // 从标准输入中读取所有的字符串，放入数组a中
    String[] a = StdIn.readAllStrings();

    // 排序数组a
    Arrays.sort(a);

    // 创建Record的数组
    Record[] records = new Record[a.length];

    // 创建第一个Record
    records[0] = new Record(a[0]);
    // Record的index
    int n = 0;

    for (int i = 1; i < a.length; i++) {
      if (records[n].getWord().equals(a[i])) {
        // 如果Record存在，增加频率
        records[n].addFreq();
      } else {
        // 如果Record不存在，创建频率
        records[++n] = new Record(a[i]);
      }
    }

    // 排序records
    Arrays.sort(records, 0, n);

    for (int i = 0; i <= n; i++) {
      Record record = records[i];
      System.out.println(record.getWord() + ": " + record.getFreq());
    }
  }
}
