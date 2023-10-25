package br.com.clebersonp.string_tempates;

import static java.lang.StringTemplate.RAW;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author cleberson
 */
public class TestStringTemplates {

  public static void main(String[] args) {

    int x = 10, y = 20;
    String s = STR."\{x} + \{y} = \{x + y}";
    System.out.println(s);

    String time = STR."The time is \{
        // The java.time.format package is very useful
        DateTimeFormatter
            .ofPattern("HH:mm:ss")
            .format(LocalTime.now())
        } right now";
    System.out.println(time);

    String[] fruits = { "apples", "oranges", "peaches" };
    String fruitsString = STR."\{fruits[0]}, \{
        STR."\{fruits[1]}, \{fruits[2]}"
      }";
    System.out.println(fruitsString);

    String title = "My Web Page";
    String text = "Hello, World";
    String html = STR."""
        <html>
          <head>
            <title>\{title}</title>
          </head>
          <body>
            <p>\{text}</p>
          </body>
        </html>
        """;
    System.out.println(html);

    String name = "Vandoca Chupetines";
    String phone = "(024) 242424-2424";
    int age = 64;
    String json = STR."""
        {
          "age": \{age},
          "name": "\{name}",
          "phone": "\{phone}",
        }
        """;
    System.out.println(json);

    StringTemplate st = RAW."\{x} plus \{y} equals \{y + y}";
    System.out.println(st);
    System.out.println(st.fragments());
    System.out.println(st.values());
    System.out.println(st.interpolate());
    System.out.println(STR.process(st));

  }

}
