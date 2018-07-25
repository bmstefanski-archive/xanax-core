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
