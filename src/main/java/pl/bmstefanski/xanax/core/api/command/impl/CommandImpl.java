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

package pl.bmstefanski.xanax.core.api.command.impl;

import java.util.List;
import pl.bmstefanski.xanax.core.api.command.Command;

public class CommandImpl implements Command {

  private String name;
  private String description;
  private String usage;
  private String permission;
  private int minArguments;
  private int maxArguments;
  private List<String> aliases;

  CommandImpl(String name, String description, String usage, String permission,
      int minArguments, int maxArguments, List<String> aliases) {
    this.name = name;
    this.description = description;
    this.usage = usage;
    this.permission = permission;
    this.minArguments = minArguments;
    this.maxArguments = maxArguments;
    this.aliases = aliases;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public String getUsage() {
    return this.usage;
  }

  @Override
  public String getPermission() {
    return this.permission;
  }

  @Override
  public int getMinArguments() {
    return this.minArguments;
  }

  @Override
  public int getMaxArguments() {
    return this.maxArguments;
  }

  @Override
  public List<String> getAliases() {
    return this.aliases;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public void setUsage(String usage) {
    this.usage = usage;
  }

  @Override
  public void setPermission(String permission) {
    this.permission = permission;
  }

  @Override
  public void setMinArguments(int minArguments) {
    this.minArguments = minArguments;
  }

  @Override
  public void setMaxArguments(int maxArguments) {
    this.maxArguments = maxArguments;
  }

  @Override
  public void setAliases(List<String> aliases) {
    this.aliases = aliases;
  }

}
