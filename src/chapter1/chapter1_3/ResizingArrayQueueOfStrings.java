package chapter1.chapter1_3;

public class ResizingArrayQueueOfStrings {
  private String[] a = (String[]) new Object[1];
  private int N = 0;

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  private void resize(int max) {
    String[] temp = (String[]) new Object[max];

    for (int i = 0; i < N; i++) {
      temp[i] = a[i];
    }

    a = temp;
  }

  public void enqueue(String s) {
    if (N == a.length) resize(N * 2);
    a[N++] = s;
  }

  public String dequeue() {
    String s = a[0];

    for (int i = 0; i < N - 1; i++) {
      a[i] = a[i + 1];
    }
    N--;
    if (N == a.length / 4) resize(a.length / 2);
    return s;
  }

}
