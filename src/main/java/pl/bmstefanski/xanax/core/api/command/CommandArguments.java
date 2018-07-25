package pl.bmstefanski.xanax.core.api.command;

import com.google.common.collect.ImmutableList;
import org.bukkit.entity.Player;

public interface CommandArguments {

  String get(int index);

  Player getPlayer(int index);

  ImmutableList<String> getAll();

}
