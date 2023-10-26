package br.com.clebersonp.record_patterns;

import java.util.Objects;

/**
 * Extend pattern matching to destructure instances of record classes, enabling more sophisticated data queries.
 * <p>
 * Add nested patterns, enabling more composable data queries.
 *
 * @author cleberson
 */
public class TestRecordPatterns {

  public static void main(String[] args) {
    formatAndPrintUserData(new User("John", "123Ab?#", true));
    formatAndPrintUserData(new User("John", null, false));
    formatAndPrintUserData(new User(null, null, false));
    formatAndPrintUserData(null);
  }

  public static void formatAndPrintUserData(Object obj) {
    if (obj instanceof User(String userName, String userPass, boolean enabled)) {
      String format = STR. """
          User name: \{ Objects.nonNull(userName) ? userName.toUpperCase() : userName }, \
          password: \{ Objects.nonNull(userPass) ? userPass.replaceAll(".", "*") : userPass }, \
          enabled: \{ enabled }""" ;
      System.out.println(format);
    } else {
      System.out.println("Nothing to do");
    }
  }

  record User(String name, String password, boolean isEnabled) {

  }
}
