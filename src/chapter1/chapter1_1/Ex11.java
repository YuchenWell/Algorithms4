package chapter1.chapter1_1;

public class Ex11 {
  public static void printBooleanMatrix(boolean[][] matrix) {
    // 第一行： 列序号
    System.out.print(' ');
    for (int i = 0; i < matrix[0].length; i++) {
      System.out.print(i);
    }
    System.out.println();

    // 第二行开始
    for (int i = 0; i < matrix.length; i++) {
      System.out.print(i + 1);
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] ? "*" : " ");
      }
      System.out.println();
    }

  }

  public static void main(String[] args) {
    boolean[][] a = { { true, false, true }, { false, true, false }, { true, true, false }, { true, true, false } };
    printBooleanMatrix(a);

  }
}
