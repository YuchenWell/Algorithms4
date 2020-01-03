package chapter1.chapter1_3;

public class Parentheses {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    String test1 = "[()]{}{[()()]()}";
    String test2 = "[(])";

    String s = test2;
    String[] inputs = s.split("");

    for (String input : inputs) {
      if (input.equals("{") || input.equals("[") || input.equals("(")) {
        stack.push(input);
      } else if (!input.isEmpty()) {
        switch (input) {
          case "}":
            if (!stack.pop().equals("{")) {
              System.out.println(false);
              return;
            }
            break;
          case "]":
            if (!stack.pop().equals("[")) {
              System.out.println(false);
              return;
            }
            break;
          case ")":
            if (!stack.pop().equals("(")) {
              System.out.println(false);
              return;
            }
            break;
        }
      }
    }
    System.out.println(stack.isEmpty());
  }
}
