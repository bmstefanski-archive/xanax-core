package pl.bmstefanski.xanax.core.drop.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.bmstefanski.xanax.core.api.bean.CommandBean;
import pl.bmstefanski.xanax.core.api.command.CommandArguments;
import pl.bmstefanski.xanax.core.api.command.CommandExecutor;
import pl.bmstefanski.xanax.core.api.command.CommandInfo;
import pl.bmstefanski.xanax.core.drop.DropModule;

@CommandBean
public class DropCommand implements CommandExecutor {

  private final DropModule plugin;

  public DropCommand(DropModule plugin) {
    this.plugin = plugin;
  }

  @CommandInfo("drop")
  @Override
  public void execute(CommandSender sender, CommandArguments args) {
    if (!(sender instanceof Player)) {
      return;
    }
  }

}