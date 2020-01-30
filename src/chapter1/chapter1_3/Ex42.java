package chapter1.chapter1_3;


import edu.princeton.cs.algs4.StdOut;

/*************************************************************************
 * Ex 1.3.41
 * 复制栈
 *************************************************************************/

public class Ex42 {
  public static void main(String[] args) {
    Stack<String> stack1 = new Stack<String>();

    stack1.push("A");
    stack1.push("B");
    stack1.push("C");
    stack1.push("D");

    StdOut.print("stack 1 (Original): ");
    for (String string : stack1) {
      StdOut.print(string);
    }

    Stack<String> stack2 = new Stack<String>(stack1);

    StdOut.println("");
    StdOut.print("Stack 2 (copied stack1): ");
    for (String string : stack2) {
      StdOut.print(string);
    }

    stack1.pop();
    stack1.pop();

    StdOut.println("");
    StdOut.print("Stack 1 (stack 1 pop *2): ");
    for (String string : stack1) {
      StdOut.print(string);
    }

    StdOut.println("");
    StdOut.print("Stack 2 (stack 1 pop *2): ");
    for (String string : stack2) {
      StdOut.print(string);
    }

    stack2.pop();

    StdOut.println("");
    StdOut.print("Stack 1 (stack 2 pop *1): ");
    for (String string : stack1) {
      StdOut.print(string);
    }

    StdOut.println("");
    StdOut.print("Stack 2 (stack 2 pop *1): ");
    for (String string : stack2) {
      StdOut.print(string);
    }

  }

}
