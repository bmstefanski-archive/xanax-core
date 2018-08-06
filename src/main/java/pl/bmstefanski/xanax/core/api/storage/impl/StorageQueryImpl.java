/*
 * MIT License
 *
 * Copyright (c) 2018 Bartłomiej Stefański
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

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
