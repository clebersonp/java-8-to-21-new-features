package br.com.clebersonp.pattern_instanceof;

/**
 * @author cleberson
 */
public class TestPatternMatchingInstanceof {

  public static void main(String[] args) {
    String s = "jdk.java";
    boolean isValid = isValidStringType(s);
    System.out.printf("Is '%s' valid? %s%n", s, isValid ? "Yes" : "No");

    s = "jdk";
    isValid = isValidStringType(s);
    System.out.printf("Is '%s' valid? %s%n", s, isValid ? "Yes" : "No");

  }

  public static boolean isValidStringType(Object o) {
    return (o instanceof String s) && (s.length() > 5);
  }

}
