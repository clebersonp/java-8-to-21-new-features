package br.com.clebersonp.scope_values;

/**
 * Introduce scoped values, values that may be safely and efficiently shared to methods without using method parameters.
 * They are preferred to thread-local variables, especially when using large numbers of virtual threads. In effect, a
 * scoped value is an implicit method parameter. A scoped value allows data to be safely and efficiently shared between
 * methods in a large program without resorting to method arguments. It is a variable of type ScopedValue. Typically, it
 * is declared as a final static field, so it can easily be reached from many methods.
 *
 * @author cleberson
 */
public class TestScopeValues {

  public static void main(String[] args) {
    new RebindingScopedValues().foo();

  }

}
