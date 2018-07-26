package pl.bmstefanski.xanax.core.drop;

import java.util.Locale;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pl.bmstefanski.xanax.core.XanaxCorePlugin;
import pl.bmstefanski.xanax.core.api.bean.impl.BeanContainerInitializer;
import pl.bmstefanski.xanax.core.api.command.impl.CommandInitializer;
import pl.bmstefanski.xanax.core.api.i18n.impl.InternationalizationInitializer;
import pl.bmstefanski.xanax.core.api.listener.impl.ListenerInitializer;
import pl.bmstefanski.xanax.core.api.module.Module;
import pl.bmstefanski.xanax.core.api.module.ModuleInfo;
import pl.bmstefanski.xanax.core.api.module.impl.event.ModuleStartEvent;
import pl.bmstefanski.xanax.core.api.module.impl.event.ModuleStopEvent;
import pl.bmstefanski.xanax.core.drop.entity.DropUserManager;
import pl.bmstefanski.xanax.core.drop.entity.impl.DropUserManagerImpl;

@ModuleInfo(name = "drop", version = "0.0.2")
public class DropModule implements Module {

  private DropManager dropManager;
  private DropUserManager userManager;

  @EventHandler(priority = EventPriority.LOWEST)
  @Override
  public void onStart(ModuleStartEvent event) {
    ConfigurationSerialization.registerClass(DropImpl.class, "Drop");
    this.dropManager = new DropManagerImpl();
    this.userManager = new DropUserManagerImpl();

    BeanContainerInitializer.initialize(DropConstants.MODULE_PACKAGE_SCOPE, this);
    InternationalizationInitializer.initialize(Locale.ENGLISH, DropConstants.MODULE_PACKAGE_SCOPE);
    ListenerInitializer.initialize(this.getPlugin(), DropConstants.MODULE_PACKAGE_SCOPE_LISTENER);
    CommandInitializer.initialize(DropConstants.MODULE_PACKAGE_SCOPE_COMMAND);
  }

  @EventHandler(priority = EventPriority.LOWEST)
  @Override
  public void onStop(ModuleStopEvent event) {

  }

  @Override
  public Plugin getPlugin() {
    return JavaPlugin.getPlugin(XanaxCorePlugin.class);
  }

  public DropManager getDropManager() {
    return dropManager;
  }

  public DropUserManager getUserManager() {
    return userManager;
  }

}