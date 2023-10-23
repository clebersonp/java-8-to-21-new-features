package br.com.clebersonp.sealed_classes;

/**
 * @author cleberson
 */
public record Start() implements Celestial {

  @Override
  public String getName() {
    return "Sun";
  }
}
