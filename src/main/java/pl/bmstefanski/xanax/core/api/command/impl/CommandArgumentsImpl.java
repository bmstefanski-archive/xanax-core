package pl.bmstefanski.xanax.core.api.command.impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pl.bmstefanski.xanax.core.api.command.CommandArguments;

public class CommandArgumentsImpl implements CommandArguments {

  private final List<String> args;

  CommandArgumentsImpl(List<String> args) {
    this.args = args;
  }

  @Override
  public String get(int index) {
    return this.args.get(index);
  }

  @Override
  public Player getPlayer(int index) {
    return Bukkit.getPlayerExact(this.get(index));
  }

  @Override
  public ImmutableList<String> getAll() {
    return ImmutableList.copyOf(this.args);
  }

}
