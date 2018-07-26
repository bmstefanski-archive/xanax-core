package pl.bmstefanski.xanax.core.drop.listener;

import java.util.Optional;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import pl.bmstefanski.xanax.core.api.bean.ListenerBean;
import pl.bmstefanski.xanax.core.api.listener.AutoRegister;
import pl.bmstefanski.xanax.core.api.listener.Listener;
import pl.bmstefanski.xanax.core.drop.Drop;
import pl.bmstefanski.xanax.core.drop.DropModule;
import pl.bmstefanski.xanax.core.drop.entity.DropUser;
import pl.bmstefanski.xanax.core.drop.event.DropItemEvent;

@AutoRegister
@ListenerBean
public class BlockBreakListener implements Listener<BlockBreakEvent> {

  private final DropModule plugin;

  public BlockBreakListener(DropModule plugin) {
    this.plugin = plugin;
  }

  @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
  @Override
  public void performEvent(BlockBreakEvent event) {
    Block block = event.getBlock();
    if (block.getType() != Material.STONE) {
      return;
    }

    Optional<DropUser> user = this.plugin.getUserManager().getUser(event.getPlayer());
    if (!user.isPresent()) {
      return;
    }

    Drop drop = this.plugin.getDropManager().getRandomDrop();
    Bukkit.getPluginManager().callEvent(new DropItemEvent(user.get(), drop));
  }

}