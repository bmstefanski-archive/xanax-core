package pl.bmstefanski.xanax.core.api.module;

public interface PluginModule {

  String getName();

  String getVersion();

  Class<? extends Module> getModuleClass();

  void setName(String name);

  void setVersion(String version);

  void setModuleClass(Class<? extends Module> module);

}