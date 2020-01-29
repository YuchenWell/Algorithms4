package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*************************************************************************
 *  Josephus problem
 *
 *  % java Ex37 7 2
 *  1 3 5 0 4 2 6
 *  第一个位置是0， 报数是1
 *************************************************************************/

public class Ex37 {
  public static void main(String[] args) {
    StdOut.print("N: ");
    int N = StdIn.readInt();

    StdOut.print("M: ");
    int M = StdIn.readInt();

    Queue<Integer> queue = new Queue<Integer>();
    for (int i = 0; i < N; i++) {
      queue.enqueue(i);
    }

    int call = 0;
    while (!queue.isEmpty()) {
      int x = queue.dequeue();
      if (++call == M) {
        StdOut.print(x);
        call = 0;
      } else {
        queue.enqueue(x);
      }
    }


  }

}
