package chapter2.chapter2_5;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class Domain implements Comparable<Domain> {
  private String domain;
  private String[] names;

  public Domain(String domain) {
    this.domain = domain;
    names = domain.split("\\.");
  }

  @Override
  public String toString() {
    return domain;
  }

  @Override
  public int compareTo(Domain that) {
    int i = this.names.length - 1;
    int j = that.names.length - 1;

    for (; i >= 0 && j >= 0; i--, j--) {
      int result = this.names[i].compareTo(that.names[j]);
      if (result != 0) return result;
    }

    return i - j;
  }

  public static void main(String[] args) {
    String[] a = StdIn.readAllStrings();

    Domain[] domains = new Domain[a.length];
    for (int i = 0; i < domains.length; i++) {
      domains[i] = new Domain(a[i]);
    }

    Arrays.sort(domains);
    for (int i = 0; i < domains.length; i++) {
      System.out.println(domains[i]);
    }
  }
}
