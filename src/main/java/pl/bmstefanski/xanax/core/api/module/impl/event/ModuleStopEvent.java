package pl.bmstefanski.xanax.core.api.module.impl.event;

import pl.bmstefanski.xanax.core.api.event.CustomEvent;
import pl.bmstefanski.xanax.core.api.module.PluginModule;

public class ModuleStopEvent extends CustomEvent {

  private final PluginModule module;

  public ModuleStopEvent(PluginModule module) {
    this.module = module;
  }

  public PluginModule getModule() {
    return this.module;
  }

}
