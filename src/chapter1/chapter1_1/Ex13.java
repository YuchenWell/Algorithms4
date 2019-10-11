package chapter1.chapter1_1;

public class Ex13 {
  private static void printTransposedMatrix(int[][] matrix) {
    for (int i = 0; i < matrix[0].length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.printf("%6d", matrix[j][i]);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[][] a = {{100, 200, 300}, {400, 500, 600}, {700, 800, 900}, {1000, 1100, 1200}};
    printTransposedMatrix(a);
  }
}
