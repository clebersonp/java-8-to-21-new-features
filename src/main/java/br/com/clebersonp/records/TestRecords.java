package br.com.clebersonp.records;

/**
 * @author cleberson
 */
public class TestRecords {

  public static void main(String[] args) {

    // Local record classes
    // Immutable class
    record Range(int lo, int hi) {

      // this declaration is equivalent to the conventional constructor
      Range {
        if (!this.isValid(lo, hi)) {
          throw new IllegalArgumentException("(%d, %d)".formatted(lo, hi));
        }
      }

      private boolean isValid(int lo, int hi) {
        return lo <= hi;
      }

      public String upperCase() {
        return this.toString().toUpperCase();
      }

      // some methods already implemented, but I can override it
      @Override
      public String toString() {
        return "Range{lo=" + this.lo + ", hi=" + this.hi + "}";
      }
    }

    Range range1 = new Range(150, 550);
    Range range2 = new Range(range1.lo(), range1.hi());
    System.out.println(range1.upperCase());
    System.out.printf("(%d, %d)%n", range1.lo(), range1.hi());
    System.out.printf("Range1.equals(Range2)? %s%n", range1.equals(range2));

  }

}
