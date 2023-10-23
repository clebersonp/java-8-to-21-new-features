package br.com.clebersonp.text_blocks;

import javax.script.ScriptException;

/**
 * @author cleberson
 */
public class TestTextBlocks {

  public static void main(String[] args) throws ScriptException {
    String literal =
        "Lorem ipsum dolor sit amet, consectetur adipiscing "
            + "elit, sed do eiusmod tempor incididunt ut labore "
            + "et dolore magna aliqua.";
    System.out.println(literal);

    // Text block with """ """ and \<line-terminator> escape
    literal = """
        Lorem ipsum dolor sit amet, consectetur adipiscing \
        elit, sed do eiusmod tempor incididunt ut labore \
        et dolore magna aliqua.\
        """;
    System.out.println(literal);

    // \s at the end of each line guarantees that each line is exactly 51 characters long
    literal = """
        Lorem ipsum dolor sit amet, consectetur adipiscing \s
        elit, sed do eiusmod tempor incididunt ut labore   \s
        et dolore magna aliqua.                            \s
        """;
    System.out.println(literal);

    literal = """
        public void print(%s object) {
          System.out.println(Objects.toString(object));
        }
        """.formatted("MyType");
    System.out.println(literal);

    // ending """ at the same line prevents a newline at the end
    literal = """
        <html>
          <body>
            <p>Hello, world</p>
          </body>
        </html>""";
    System.out.println(literal);
    System.out.println("final");

    literal = """
        SELECT "EMP_ID", "LAST_NAME" FROM "EMPLOYEE_TB"
        WHERE "CITY" = 'INDIANAPOLIS'
        ORDER BY "EMP_ID", "LAST_NAME";
        """;
    System.out.println(literal);

  }

}
