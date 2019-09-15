package chapter1.chapter1_1;

public class Ex27 {
  private static long COUNT = 0;
  private static long COUNT_BETTER = 0;

  private static double[][] MATRIX;

  public static double binomial(int N, int k, double p) {
    // 调用次数+1
    COUNT++;

    if (N == 0 && k == 0) {
      return 1.0;
    }
    if (N < 0 || k < 0) {
      return 0.0;
    }
    return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
  }

  public static double betterBinomial(int N, int k, double p) {
    MATRIX = new double[N + 1][k + 1];
    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= k; j++) {
        MATRIX[i][j] = -1;
      }
    }
    return bin(N, k, p);
  }

  public static double bin(int N, int k, double p) {
    // 调用次数+1
    COUNT_BETTER++;

    if (N == 0 && k == 0) {
      return 1.0;
    }
    if (N < 0 || k < 0) {
      return 0.0;
    }

    if (MATRIX[N][k] == -1) {
      MATRIX[N][k] = (1.0 - p) * bin(N - 1, k, p) + p * bin(N - 1, k - 1, p);
    }

    return MATRIX[N][k];
  }

  public static void main(String[] args) {
    double result1 = binomial(20, 10, 0.25);
    System.out.println("Original method (not optimized):");
    System.out.println("Result: " + result1);
    System.out.println("Method call times: " + COUNT);

    double result2 = betterBinomial(20, 10, 0.25);
    System.out.println("Original method (optimized):");
    System.out.println("Result: " + result2);
    System.out.println("Method call times: " + COUNT_BETTER + " (" + (COUNT_BETTER - COUNT) + " times better)");
  }
}
