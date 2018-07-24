package pl.bmstefanski.xanax.core.api.storage.impl;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import pl.bmstefanski.xanax.core.api.storage.Storage;

public class HikariStorageImpl implements Storage {

  private final HikariDataSource hikariDataSource;

  public HikariStorageImpl(HikariConfig hikariConfig) {
    this.hikariDataSource = new HikariDataSource(hikariConfig);
  }

  @Override
  public Connection getConnection() throws SQLException {
    return this.hikariDataSource.getConnection();
  }

  @Override
  public void closeConnection() {
    this.hikariDataSource.close();
  }

  @Override
  public boolean isAvailable() {
    return this.hikariDataSource.isRunning();
  }

}
