package pl.bmstefanski.xanax.core.api.storage;

import java.sql.ResultSet;

public interface StorageQuery {

  int executeUpdate();

  ResultSet executeQuery();

}
