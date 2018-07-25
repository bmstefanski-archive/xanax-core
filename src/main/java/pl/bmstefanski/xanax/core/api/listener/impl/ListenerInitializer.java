package pl.bmstefanski.xanax.core.api.listener.impl;

import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.reflections.Reflections;
import pl.bmstefanski.xanax.core.api.bean.impl.BeanContainerInitializer;
import pl.bmstefanski.xanax.core.api.listener.AutoRegister;

public final class ListenerInitializer {

  public static void initialize(Plugin plugin, String packageName) {
    Reflections reflections = new Reflections(packageName);
    Set<Class<?>> classes = reflections.getTypesAnnotatedWith(AutoRegister.class);

    classes.forEach(clazz -> {
      Listener listener = (Listener) BeanContainerInitializer.getBeansInstances().get(clazz.getName());
      Bukkit.getPluginManager().registerEvents(listener, plugin);
    });
  }

  private ListenerInitializer() {
  }

}
