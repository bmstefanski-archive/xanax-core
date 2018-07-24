package pl.bmstefanski.xanax.core.api.storage;

public interface Storage {

  void getConnection();

  void closeConnection();

  boolean isAvailable();

}
