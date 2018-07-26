package pl.bmstefanski.xanax.core.drop.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import pl.bmstefanski.xanax.core.api.bean.ListenerBean;
import pl.bmstefanski.xanax.core.api.listener.AutoRegister;
import pl.bmstefanski.xanax.core.api.listener.Listener;
import pl.bmstefanski.xanax.core.drop.DropModule;

@AutoRegister
@ListenerBean
public class LoginListener implements Listener<PlayerLoginEvent> {

  private final DropModule plugin;

  public LoginListener(DropModule plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  @Override
  public void performEvent(PlayerLoginEvent event) {

  }

}
