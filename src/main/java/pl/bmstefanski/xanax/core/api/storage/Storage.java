package pl.bmstefanski.xanax.core.api.storage;

import java.sql.Connection;
import java.sql.SQLException;

public interface Storage {

  Connection getConnection() throws SQLException;

  void closeConnection();

  boolean isAvailable();

}
