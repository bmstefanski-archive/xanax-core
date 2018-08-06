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
import pl.bmstefanski.xanax.core.api.helper.Buildable;

public class CommandBuilder implements Buildable<Command> {

  private String name;
  private String description;
  private String usage;
  private String permission;
  private int minArguments;
  private int maxArguments;
  private List<String> aliases;

  public CommandBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public CommandBuilder withDescription(String description) {
    this.description = description;
    return this;
  }

  public CommandBuilder withUsage(String usage) {
    this.usage = usage;
    return this;
  }

  public CommandBuilder withPermission(String permission) {
    this.permission = permission;
    return this;
  }

  public CommandBuilder withMinArguments(int minArguments) {
    this.minArguments = minArguments;
    return this;
  }

  public CommandBuilder withMaxArguments(int maxArguments) {
    this.maxArguments = maxArguments;
    return this;
  }

  public CommandBuilder withAliases(List<String> aliases) {
    this.aliases = aliases;
    return this;
  }

  @Override
  public Command build() {
    return new CommandImpl(this.name, this.description, this.usage, this.permission,
        this.minArguments, this.maxArguments, this.aliases);
  }

}
