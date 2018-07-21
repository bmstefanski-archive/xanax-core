package pl.bmstefanski.xanax.core.guild.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.bmstefanski.xanax.core.api.listener.AutoRegister;
import pl.bmstefanski.xanax.core.api.listener.Listener;

@AutoRegister
public class PlayerJoinListener implements Listener<PlayerJoinEvent> {

  @EventHandler(priority = EventPriority.LOWEST)
  @Override
  public void performEvent(PlayerJoinEvent event) {
    event.getPlayer().sendMessage("CHUJ XD");
  }

}
