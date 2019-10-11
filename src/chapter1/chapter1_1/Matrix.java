package chapter1.chapter1_1;

/**
 * Use in Ex 1.1.33
 **/
public class Matrix {
  public static double dot(double[] x, double[] y) {
    double result = 0.0;
    if (x.length == y.length) {
      for (int i = 0; i < x.length; i++) {
        result += x[i] * y[i];
      }
      return result;
    } else {
      System.out.println("Error!");
      return result;
    }

  }

  public static double[][] mult(double[][] a, double[][] b) {
    if (a[0].length == b.length) {
      double[][] result = new double[a.length][b[0].length];
      for (int i = 0; i < result.length; i++) {
        for (int j = 0; j < result[0].length; j++) {
          for (int k = 0; k < b.length; k++) {
            result[i][j] += a[i][k] * b[k][j];
          }
        }
      }
      return result;
    } else {
      System.out.println("Error!");
      return null;
    }
  }

  public static double[][] transpose(double[][] a) {
    double[][] result = new double[a[0].length][a.length];
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        result[i][j] = a[j][i];
      }
    }
    return result;
  }

  public static double[] mult(double[][] a, double[] x) {
    if (a[0].length == x.length) {
      double[] result = new double[x.length];
      for (int i = 0; i < x.length; i++) {
        for (int j = 0; j < a[0].length; j++) {
          result[i] += x[i] * a[i][j];
        }
      }
      return result;
    } else {
      return null;
    }
  }

  public static double[] mult(double[] y, double[][] a) {
    if (a.length == y.length) {
      double[] result = new double[y.length];
      for (int i = 0; i < y.length; i++) {
        for (int j = 0; j < a[0].length; j++) {
          result[i] += y[i] * a[j][i];
        }
      }
      return result;
    } else {
      return null;
    }
  }
}
