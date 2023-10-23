package br.com.clebersonp.sealed_classes;

/**
 * @author cleberson
 */
public record Comet() implements Celestial {

  @Override
  public String getName() {
    return "840 NF";
  }
}
