package pl.bmstefanski.xanax.core.api.module;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import pl.bmstefanski.xanax.core.api.module.impl.event.ModuleStartEvent;
import pl.bmstefanski.xanax.core.api.module.impl.event.ModuleStopEvent;

public interface Module extends Listener {

  void onStart(ModuleStartEvent event);

  void onStop(ModuleStopEvent event);

  Plugin getPlugin();

}
