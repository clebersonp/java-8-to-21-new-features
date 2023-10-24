package br.com.clebersonp.sequenced_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author cleberson
 */
public class TestSequencedCollections {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>(Arrays.asList("One", "Tow", "Three", "Four", "Five"));
    list.addFirst("Zero");
    list.addLast("Six");
    System.out.println(list.stream().findFirst().orElse("Has no element"));
    System.out.println(list.isEmpty() ? "Has no element" : list.getFirst());
    System.out.println(list.isEmpty() ? "Has no element" : list.getLast());

    List<String> reversed = list.reversed();
    System.out.println(reversed);

    System.out.printf("Remove first: %s\n", reversed.removeFirst());
    System.out.printf("Remove last: %s\n", reversed.removeLast());

    System.out.println(reversed);

  }

}
