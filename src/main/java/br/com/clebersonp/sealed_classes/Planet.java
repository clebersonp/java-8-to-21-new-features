package br.com.clebersonp.sealed_classes;

/**
 * @author cleberson
 */
public record Planet() implements Celestial {

  @Override
  public String getName() {
    return "Earth";
  }
}
