package pl.bmstefanski.xanax.core.api.bean.impl;

import com.google.common.collect.ImmutableMap;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import pl.bmstefanski.xanax.core.api.bean.CommandBean;
import pl.bmstefanski.xanax.core.api.bean.ListenerBean;
import pl.bmstefanski.xanax.core.api.bean.UtilityBean;
import pl.bmstefanski.xanax.core.api.module.Module;

public final class BeanContainerInitializer {

  private static final Map<String, Object> BEAN_INSTANCES = new LinkedHashMap<>();

  public static void initialize(String packageName, Module module) {
    Reflections reflections = new Reflections(packageName, new TypeAnnotationsScanner(),
        new SubTypesScanner());

    Set<Class<?>> commandBeans = reflections.getTypesAnnotatedWith(CommandBean.class);
    Set<Class<?>> listenerBeans = reflections.getTypesAnnotatedWith(ListenerBean.class);
    Set<Class<?>> utilityBeans = reflections.getTypesAnnotatedWith(UtilityBean.class);

    List<Set<Class<?>>> beans = Arrays
        .asList(commandBeans, listenerBeans, utilityBeans);

    beans.forEach(classes -> classes.forEach(aClass -> {
      try {

        if (aClass.getConstructors()[0].getParameterCount() == 1) {
          BEAN_INSTANCES.putIfAbsent(aClass.getName(),
              aClass.getDeclaredConstructor(module.getClass()).newInstance(module));
          return;
        }

        BEAN_INSTANCES.putIfAbsent(aClass.getName(), aClass.newInstance());
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
        e.printStackTrace();
      }
    }));
  }

  public static ImmutableMap<String, Object> getBeansInstances() {
    return ImmutableMap.copyOf(BEAN_INSTANCES);
  }

  private BeanContainerInitializer() {
  }

}
