package pl.bmstefanski.xanax.core.guild;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pl.bmstefanski.xanax.core.XanaxCorePlugin;
import pl.bmstefanski.xanax.core.api.event.impl.ModuleStartEvent;
import pl.bmstefanski.xanax.core.api.event.impl.ModuleStopEvent;
import pl.bmstefanski.xanax.core.api.listener.impl.ListenerInitializer;
import pl.bmstefanski.xanax.core.api.module.Module;
import pl.bmstefanski.xanax.core.api.module.ModuleInfo;

@ModuleInfo(name = "guild", version = "0.0.1", clazz = GuildModule.class)
public class GuildModule implements Module {

  @EventHandler(priority = EventPriority.LOWEST)
  @Override
  public void onStart(ModuleStartEvent event) {
    ListenerInitializer.initialize(this.getPlugin(), this, "pl.bmstefanski.xanax.core.guild.listener");
  }

  @EventHandler(priority = EventPriority.LOWEST)
  @Override
  public void onStop(ModuleStopEvent event) {
  }

  @Override
  public Plugin getPlugin() {
    return JavaPlugin.getPlugin(XanaxCorePlugin.class);
  }

}
