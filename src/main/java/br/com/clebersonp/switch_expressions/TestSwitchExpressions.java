package br.com.clebersonp.switch_expressions;

import java.time.DayOfWeek;

/**
 * @author cleberson
 */
public class TestSwitchExpressions {

  public static void main(String[] args) {

    System.out.printf("%s has %d letters\n", DayOfWeek.MONDAY, numLettersOld(DayOfWeek.MONDAY));
    System.out.printf("%s has %d letters\n", DayOfWeek.WEDNESDAY, numLettersNew(DayOfWeek.WEDNESDAY));

    System.out.printf("%d letters. Result: '%s'%n", -10, howManyWithYield(-10));
    System.out.printf("%d letters. Result: '%s'%n", 0, howManyWithYield(0));
    System.out.printf("%d letters. Result: '%s'%n", 1, howManyWithYield(1));
    System.out.printf("%d letters. Result: '%s'%n", 2, howManyWithYield(2));
    System.out.printf("%d letters. Result: '%s'%n", 50, howManyWithYield(50));

  }

  public static int numLettersOld(DayOfWeek day) {
    int numLetters;
    switch (day) {
      case MONDAY:
      case FRIDAY:
      case SUNDAY:
        numLetters = 6;
        break;
      case TUESDAY:
        numLetters = 7;
        break;
      case THURSDAY:
      case SATURDAY:
        numLetters = 8;
        break;
      case WEDNESDAY:
        numLetters = 9;
        break;
      default:
        throw new IllegalStateException("Wat: " + day);
    }
    return numLetters;
  }

  public static int numLettersNew(DayOfWeek day) {
    return switch (day) {
      case MONDAY, FRIDAY, SUNDAY -> 6;
      case TUESDAY -> 7;
      case THURSDAY, SATURDAY -> 8;
      case WEDNESDAY -> 9;
    };
  }

  public static String howManyWithYield(int k) {
    return switch (k) {
      case 1 -> "one";
      case 2 -> "two";
      default -> {
        String s = k <= 0 ? "few" : "many";
        System.out.printf("\t-> %d letters, so the result will be '%s'%n", k, s);
        yield s;
      }
    };
  }

}
