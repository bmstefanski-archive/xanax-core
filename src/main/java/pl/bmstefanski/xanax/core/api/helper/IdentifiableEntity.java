package pl.bmstefanski.xanax.core.api.helper;

import java.io.Serializable;

public interface IdentifiableEntity<T extends Serializable> {

  T getIdentifier();

  void setIdentifier(T identifier);

}
