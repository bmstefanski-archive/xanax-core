package pl.bmstefanski.xanax.core.api.i18n.impl;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Set;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import pl.bmstefanski.xanax.core.XanaxCorePlugin;
import pl.bmstefanski.xanax.core.api.bean.impl.BeanContainerInitializer;
import pl.bmstefanski.xanax.core.api.i18n.Value;

public final class InternationalizationInitializer {

  public static void initialize(Locale locale, String packageName) {
    Path directoryPath = Paths
        .get(JavaPlugin.getPlugin(XanaxCorePlugin.class).getDataFolder().toString() + "/lang/");
    Path languageFilePath = Paths
        .get(directoryPath.toString(), "/language_" + locale.toLanguageTag() + ".yaml");

    try {
      if (Files.notExists(directoryPath)) {
        Files.createDirectories(directoryPath);
        Files.createFile(languageFilePath);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    Reflections reflections = new Reflections(packageName, new FieldAnnotationsScanner());
    Set<Field> fields = reflections.getFieldsAnnotatedWith(Value.class);
    FileConfiguration variables = YamlConfiguration.loadConfiguration(languageFilePath.toFile());

    fields.forEach(field -> {
      Value valueAnnotation = field.getAnnotation(Value.class);
      Object value = variables.get(valueAnnotation.value());
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
