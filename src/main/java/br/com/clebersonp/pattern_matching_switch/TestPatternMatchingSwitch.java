package br.com.clebersonp.pattern_matching_switch;

import java.math.BigDecimal;

public class TestPatternMatchingSwitch {

  public static void main(String[] args) {
    System.out.println(formatterPatternSwitch(null));
    System.out.println(formatterPatternSwitch(10));
    System.out.println(formatterPatternSwitch(2.95));
    System.out.println(formatterPatternSwitch("Night"));
    System.out.println(formatterPatternSwitch(9L));
    System.out.println(formatterPatternSwitch(new BigDecimal("96.10")));
    testStringOld("yes");
    testStringOld("yeS");
    testStringOld("y");
    testStringOld("no");
    testStringOld("nO");
    testStringOld("n");
    testStringOld("old");
    enumSwitch(Coin.HEADS);
    enumSwitch(Coin.TAILS);
    enumSwitch(new Cents(99.99));
  }

  public static void enumSwitch(Currency c) {
    switch (c) {
      case Coin.HEADS -> System.out.println(Coin.HEADS);
      case Coin.TAILS -> System.out.println(Coin.TAILS);
      case Cents ce -> System.out.println(ce.currency);
    }
  }

  public static String formatterPatternSwitch(Object obj) {
    return switch (obj) {
      case Integer i -> "int %d".formatted(i);
      case Long l -> "long %d".formatted(l);
      case Double d -> "double %f".formatted(d);
      case String s -> "String %s".formatted(s);
      case null -> "null";
      default -> obj.toString();
    };
  }

  public static void testStringOld(String response) {
    switch (response) {
      case null -> {
      }
      case String s
          when s.equalsIgnoreCase("yes")
          || s.equalsIgnoreCase("y") -> System.out.println("You got it");
      case String s
          when s.equalsIgnoreCase("no")
          || s.equalsIgnoreCase("n") -> System.out.println("Shame");
      case String _ -> System.out.println("Sorry?");
    }
  }

  enum Coin implements Currency {HEADS, TAILS}

  public sealed interface Currency permits Coin, Cents {

  }

  record Cents(double currency) implements Currency {

  }
}