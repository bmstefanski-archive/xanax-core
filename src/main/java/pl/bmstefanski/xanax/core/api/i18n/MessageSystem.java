package pl.bmstefanski.xanax.core.api.i18n;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

/*
 * @author jwiczkowsky
 * */

public class MessageSystem {

  private final JavaPlugin javaPlugin;
  private final Map<Locale, LocalizedMessages> localizedMessagesMap = new HashMap<>();

  public MessageSystem(JavaPlugin javaPlugin) {
    this.javaPlugin = javaPlugin;
    setup();
  }

  private void setup() {

    try {
      Path path = Paths.get(this.javaPlugin.getDataFolder().getAbsolutePath() + "/lang");

      if (Files.notExists(path)) {
        Files.createDirectories(path);
      }

      for (Locale locale : Locale.values()) {
        this.javaPlugin.saveResource("lang/" + locale.getLocaleCode() + ".yml", false);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    load();
  }

  private void load() {
    for (Locale locale : Locale.values()) {
      this.localizedMessagesMap.put(
          locale,
          new LocalizedMessages(locale, YamlConfiguration.loadConfiguration(
              new File(this.javaPlugin.getDataFolder().getAbsolutePath() + "/lang/" + locale.getLocaleCode() + ".yml")))
      );
    }
  }

  public LocalizedMessages getLocalizedMessages(Locale locale) {
    return this.localizedMessagesMap.get(locale);
  }

}
