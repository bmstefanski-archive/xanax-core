package pl.bmstefanski.xanax.core.guild;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pl.bmstefanski.xanax.core.XanaxCorePlugin;
import pl.bmstefanski.xanax.core.api.bean.impl.BeanContainerInitializer;
import pl.bmstefanski.xanax.core.api.command.impl.CommandInitializer;
import pl.bmstefanski.xanax.core.api.module.impl.event.ModuleStartEvent;
import pl.bmstefanski.xanax.core.api.module.impl.event.ModuleStopEvent;
import pl.bmstefanski.xanax.core.api.listener.impl.ListenerInitializer;
import pl.bmstefanski.xanax.core.api.module.Module;
import pl.bmstefanski.xanax.core.api.module.ModuleInfo;

@ModuleInfo(name = "guild", version = "0.0.2")
public class GuildModule implements Module {

  private static final String MODULE_PACKAGE_SCOPE = "pl.bmstefanski.xanax.core.guild";

  @EventHandler(priority = EventPriority.LOWEST)
  @Override
  public void onStart(ModuleStartEvent event) {
    BeanContainerInitializer.initialize(MODULE_PACKAGE_SCOPE, this);
    ListenerInitializer.initialize(this.getPlugin(), MODULE_PACKAGE_SCOPE + ".listener");
    CommandInitializer.initialize(MODULE_PACKAGE_SCOPE + ".command");
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
