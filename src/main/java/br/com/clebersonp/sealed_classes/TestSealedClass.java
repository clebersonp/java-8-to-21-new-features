package br.com.clebersonp.sealed_classes;

/**
 * @author cleberson
 */
public class TestSealedClass {

  public static void main(String[] args) {
    Celestial c = new Start();
    System.out.printf("Before: %s, after: %s%n", c.getName(), testing(c));
  }

  public static String testing(Celestial c) {
    return switch (c) {
      case Planet p -> p.getName().toUpperCase();
      case Start s -> s.getName().toLowerCase();
      case Comet comet -> comet.getName();
      // no default needed! all subtypes covered
    };
  }

}
