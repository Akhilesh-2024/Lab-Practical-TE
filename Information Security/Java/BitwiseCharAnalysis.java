public class BitwiseCharAnalysis {
  public static void main(String[] args) {
      String s = "Hello World";

      System.out.printf("%-6s %-8s %-8s %-8s%n", "Char", "ASCII", "&127", "^127");
      System.out.println("--------------------------------");

      for (char c : s.toCharArray()) {
          int original = (int) c;
          int andVal = original & 127;
          int xorVal = original ^ 127;
          System.out.printf("%-6c %-8d %-8d %-8d%n", c, original, andVal, xorVal);
      }
  }
}
