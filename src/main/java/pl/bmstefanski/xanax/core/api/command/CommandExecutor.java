package pl.bmstefanski.xanax.core.api.command;

import org.bukkit.command.CommandSender;

public interface CommandExecutor {

  void execute(CommandSender commandSender, CommandArguments args);

}
