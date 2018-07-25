package pl.bmstefanski.xanax.core.api.module;

public interface PluginModule {

  String getName();

  String getVersion();

  void setName(String name);

  void setVersion(String version);

}
