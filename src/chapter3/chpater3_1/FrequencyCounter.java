package chapter3.chpater3_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {
  public static void main(String[] args) {
    /*
     * 用来测试的文件
     * - tinyTale.txt
     * - tale.txt
     * - leipzig1M.txt
     */
    String filename = "algs4-data/tale.txt";
    In in = new In(filename);

    // 忽略较短的单词
    int minLen = 10;

    ST<String, Integer> st = new ST<>();

    while (!in.isEmpty()) {
      String word = in.readString();
      if (word.length() < minLen) continue;
      if (!st.contains(word)) {
        st.put(word, 1);
      } else {
        st.put(word, st.get(word) + 1);
      }
    }

    String max = "";
    st.put(max, 0);
    for (String word : st.keys()) {
      if (st.get(word) > st.get(max)) {
        max = word;
      }
    }
    StdOut.println(max + " " + st.get(max));
  }

}
