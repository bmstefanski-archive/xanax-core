package pl.bmstefanski.xanax.core.drop.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;
import pl.bmstefanski.xanax.core.api.bean.ListenerBean;
import pl.bmstefanski.xanax.core.api.listener.AutoRegister;
import pl.bmstefanski.xanax.core.api.listener.Listener;
import pl.bmstefanski.xanax.core.drop.DropModule;

@AutoRegister
@ListenerBean
public class AsyncPreLoginListener implements Listener<AsyncPlayerPreLoginEvent> {

  private final DropModule plugin;

  public AsyncPreLoginListener(DropModule plugin) {
    this.plugin = plugin;
  }

  @EventHandler(priority = EventPriority.HIGH)
  @Override
  public void performEvent(AsyncPlayerPreLoginEvent event) {
    if (event.getLoginResult() != Result.ALLOWED) {
      return;
    }
  }

}
