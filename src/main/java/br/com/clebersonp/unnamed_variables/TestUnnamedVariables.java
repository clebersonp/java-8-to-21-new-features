package br.com.clebersonp.unnamed_variables;

import java.net.http.HttpClient;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author cleberson
 */
public class TestUnnamedVariables {
  public static void main(String[] args) {
    var vandoca = new User("Vandoca Chupa", "vandoca.chupa@chupetines.com");

    var _ = format(vandoca);

    String s = "21A";
    try {
      var _ = Integer.parseInt(s);
      // number is valid
    } catch (NumberFormatException _) {
      System.out.printf("Bad number: %s\n", s);
    }

    try (var _ = HttpClient.newHttpClient()) {
      // no use of httpClient instance
      System.out.println("NODATA");
    }

    Map<String, String> map = Stream.of("A", "B", "C", "D")
        .collect(Collectors.toMap(String::toLowerCase, _ -> "NODATA"));
    System.out.println(map);
  }
  private static User format(User user) {
    return new User(user.name().toUpperCase(), user.email().toUpperCase());
  }
  record User(String name, String email) { }
}
