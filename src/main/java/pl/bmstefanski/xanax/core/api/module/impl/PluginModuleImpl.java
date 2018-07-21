package pl.bmstefanski.xanax.core.api.module.impl;

import pl.bmstefanski.xanax.core.api.module.Module;
import pl.bmstefanski.xanax.core.api.module.PluginModule;

public class PluginModuleImpl implements PluginModule {

  private String name;
  private String version;
  private Class<? extends Module> module;

  PluginModuleImpl(String name, String version, Class<? extends Module> module) {
    this.name = name;
    this.version = version;
    this.module = module;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getVersion() {
    return this.version;
  }

  @Override
  public Class<? extends Module> getModuleClass() {
    return module;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public void setModuleClass(Class<? extends Module> module) {
    this.module = module;
  }

}
