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
