package br.com.clebersonp.sealed_classes;

/**
 * @author cleberson
 */
public sealed interface Celestial permits Planet, Start, Comet {

  String getName();
}
