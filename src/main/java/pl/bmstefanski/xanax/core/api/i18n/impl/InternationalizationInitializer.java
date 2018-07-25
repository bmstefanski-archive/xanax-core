package pl.bmstefanski.xanax.core.api.i18n.impl;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Set;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import pl.bmstefanski.xanax.core.XanaxCorePlugin;
import pl.bmstefanski.xanax.core.api.bean.impl.BeanContainerInitializer;
import pl.bmstefanski.xanax.core.api.i18n.Value;

public final class InternationalizationInitializer {

  public static void initialize(Locale locale, String packageName) {
    Reflections reflections = new Reflections(packageName, new FieldAnnotationsScanner());
    Set<Field> fields = reflections.getFieldsAnnotatedWith(Value.class);

    String path = "lang/language_" + locale.toLanguageTag() + ".yaml";

    JavaPlugin.getPlugin(XanaxCorePlugin.class).saveResource(path, false);
    Reader defConfigStream = new InputStreamReader(
        XanaxCorePlugin.class.getResourceAsStream("/" + path),
        StandardCharsets.UTF_8
    );

    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(defConfigStream);
    yamlConfiguration.options().copyDefaults(true);

    fields.forEach(field -> {
      Value valueAnnotation = field.getAnnotation(Value.class);
      Object value = yamlConfiguration.get(valueAnnotation.value());
      try {
        field.setAccessible(true);
        Object instance = BeanContainerInitializer.getBeansInstances()
            .get(field.getDeclaringClass().getName());
        field.set(instance, value);
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    });
  }

  private InternationalizationInitializer() {
  }

}
