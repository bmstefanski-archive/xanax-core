package pl.bmstefanski.xanax.core.api.i18n;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public class LocalizedMessages {

  private final Locale locale;

  private final Map<String, String> messagesMap = new HashMap<>();

  LocalizedMessages(Locale locale, FileConfiguration yamlConfiguration) {
    this.locale = locale;
    load(yamlConfiguration);
  }

  private void load(FileConfiguration fileConfiguration) {
    fileConfiguration.getKeys(true)
        .forEach(key -> this.messagesMap.put(key, fileConfiguration.getString(key)));
  }

  public Locale getLocale() {
    return this.locale;
  }

  public MessageBuilder getMessage(String key) {
    return new MessageBuilder(this.messagesMap.get(key));
  }

}
