package pl.bmstefanski.xanax.core.api.listener.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.reflections.Reflections;
import pl.bmstefanski.xanax.core.api.listener.AutoRegister;
import pl.bmstefanski.xanax.core.api.module.Module;

public final class ListenerInitializer {

  public static void initialize(Plugin plugin, Module module, String packageName) {
    Reflections reflections = new Reflections(packageName);
    Set<Class<?>> classes = reflections.getTypesAnnotatedWith(AutoRegister.class);

    classes.forEach(clazz -> {
      try {
        Parameter[] parameters = clazz.getConstructors()[0].getParameters();

        Listener listener = (Listener) clazz.newInstance();

        if (parameters.length == 1) {
          listener = (Listener) clazz.getConstructor(Module.class).newInstance(module);
        }

        Bukkit.getPluginManager().registerEvents(listener, plugin);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
        e.printStackTrace();
      }
    });
  }

  private ListenerInitializer() {
  }

}
