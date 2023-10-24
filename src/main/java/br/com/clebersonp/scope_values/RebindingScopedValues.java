package br.com.clebersonp.scope_values;

/**
 * @author cleberson
 */
public class RebindingScopedValues {

  private static final ScopedValue<String> X = ScopedValue.newInstance();

  public void foo() {
//    System.out.println(X.get()); java.util.NoSuchElementException, scoped without value
    ScopedValue.where(X, "hello").run(this::bar);
//    System.out.println(X.get()); java.util.NoSuchElementException, out the scoped
  }

  private void bar() {
    System.out.println(X.get()); // prints hello
    ScopedValue.where(X, "goodbye").run(this::baz); // rebinding and call with run
    System.out.println(X.get()); // prints hello
    System.out.println(X.get()); // prints hello
  }

  private void baz() {
    System.out.println(X.get()); // prints goodbye
    System.out.println(X.get()); // prints goodbye
  }

}
