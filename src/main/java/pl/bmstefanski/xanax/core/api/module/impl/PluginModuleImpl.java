package pl.bmstefanski.xanax.core.api.module.impl;

import pl.bmstefanski.xanax.core.api.module.PluginModule;

public class PluginModuleImpl implements PluginModule {

  private String name;
  private String version;

  PluginModuleImpl(String name, String version) {
    this.name = name;
    this.version = version;
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
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setVersion(String version) {
    this.version = version;
  }

}
