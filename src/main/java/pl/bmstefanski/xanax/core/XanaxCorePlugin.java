package pl.bmstefanski.xanax.core;

import java.util.function.Consumer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.plugin.java.JavaPlugin;
import pl.bmstefanski.xanax.core.api.module.impl.event.ModuleStartEvent;
import pl.bmstefanski.xanax.core.api.module.impl.event.ModuleStopEvent;
import pl.bmstefanski.xanax.core.api.module.PluginModule;
import pl.bmstefanski.xanax.core.api.module.impl.ModuleInitializer;
import pl.bmstefanski.xanax.core.guild.GuildModule;

public class XanaxCorePlugin extends JavaPlugin implements Listener {

  @Override
  public void onLoad() {
    ModuleInitializer.registerModule(new GuildModule());
  }

  @Override
  public void onEnable() {
    this.modulesAction(module -> {
      try {
        Bukkit.getPluginManager().registerEvents(module.getModuleClass().newInstance(), this);
      } catch (InstantiationException | IllegalAccessException e) {
        e.printStackTrace();
      }

      Bukkit.getPluginManager().callEvent(new ModuleStartEvent(module));
    });

    this.getServer().getPluginManager().registerEvents(this, this);
  }

  @EventHandler(priority = EventPriority.LOWEST)
  public void onDisable(PluginDisableEvent event) {
    this.modulesAction(module -> Bukkit.getPluginManager().callEvent(new ModuleStopEvent(module)));
  }

  private void modulesAction(Consumer<? super PluginModule> action) {
    ModuleInitializer.getAllModules().forEach(action);
  }

}
