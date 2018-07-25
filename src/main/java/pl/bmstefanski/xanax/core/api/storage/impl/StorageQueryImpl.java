package pl.bmstefanski.xanax.core.api.storage.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import pl.bmstefanski.xanax.core.api.storage.StorageQuery;
import pl.bmstefanski.xanax.core.api.storage.impl.callable.ExecuteQueryCallable;
import pl.bmstefanski.xanax.core.api.storage.impl.callable.ExecuteUpdateCallable;

public class StorageQueryImpl implements StorageQuery {

  private final ExecutorService executorService;
  private final PreparedStatement preparedStatement;

  public StorageQueryImpl(ExecutorService executorService, PreparedStatement preparedStatement) {
    this.executorService = executorService;
    this.preparedStatement = preparedStatement;
  }

  @Override
  public int executeUpdate() {
    Callable<Integer> executeUpdateCallable = new ExecuteUpdateCallable(this.preparedStatement);
    Future<Integer> future = this.executorService.submit(executeUpdateCallable);

    Integer result = 0;
    try {
      result = future.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

    return result;
  }

  @Override
  public ResultSet executeQuery() {
    Callable<ResultSet> executeQueryCallable = new ExecuteQueryCallable(this.preparedStatement);
    Future<ResultSet> future = this.executorService.submit(executeQueryCallable);

    ResultSet result = null;
    try {
      result = future.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

    return result;
  }

}
