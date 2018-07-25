package pl.bmstefanski.xanax.core.api.command;

import java.util.List;

public interface Command {

  String getName();

  String getDescription();

  String getUsage();

  String getPermission();

  int getMinArguments();

  int getMaxArguments();

  List<String> getAliases();

  void setName(String name);

  void setDescription(String description);

  void setUsage(String usage);

  void setPermission(String permission);

  void setMinArguments(int minArguments);

  void setMaxArguments(int maxArguments);

  void setAliases(List<String> aliases);

}
