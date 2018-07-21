package pl.bmstefanski.xanax.core.api.module.impl;

import com.google.common.collect.ImmutableSet;
import java.util.LinkedHashSet;
import java.util.Set;
import pl.bmstefanski.xanax.core.api.module.Module;
import pl.bmstefanski.xanax.core.api.module.ModuleInfo;
import pl.bmstefanski.xanax.core.api.module.PluginModule;

public final class ModuleInitializer {

  private static final Set<PluginModule> MODULES = new LinkedHashSet<>();

  public static void registerModule(Module module) {
    Class<?> moduleClazz = module.getClass();

    if (moduleClazz.isAnnotationPresent(ModuleInfo.class)) {
      ModuleInfo moduleInfo = moduleClazz.getAnnotation(ModuleInfo.class);
      PluginModule pluginModule = new PluginModuleImpl(
          moduleInfo.name(),
          moduleInfo.version(),
          moduleInfo.clazz()
      );

      MODULES.add(pluginModule);
    }
  }

  public static ImmutableSet<PluginModule> getAllModules() {
    return ImmutableSet.copyOf(MODULES);
  }

  private ModuleInitializer() {
  }

}
