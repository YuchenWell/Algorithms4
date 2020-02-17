package chapter2.chapter2_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Multiway {
  public static void merge(In[] streams) {
    int N = streams.length;
    IndexMinPQ<String> pq = new IndexMinPQ<>(N);

    for (int i = 0; i < N; i++) {
      if (!streams[i].isEmpty()) {
        pq.insert(i, streams[i].readString());
      }
    }

    while (!pq.isEmpty()) {
      StdOut.print(pq.minKey() + " ");
      int i = pq.delMin();
      if (!streams[i].isEmpty()) {
        pq.insert(i, streams[i].readString());
      }
    }
  }

  public static void main(String[] args) {
    String[] files = new String[3];
    // A B C F G I I Z
    files[0] = "algs4-data/m1.txt";
    // B D H P Q Q
    files[1] = "algs4-data/m2.txt";
    // A B E F J N
    files[2] = "algs4-data/m3.txt";

    In[] streams = new In[files.length];
    for (int i = 0; i < files.length; i++) {
      streams[i] = new In(files[i]);
    }

    merge(streams);
  }
}
