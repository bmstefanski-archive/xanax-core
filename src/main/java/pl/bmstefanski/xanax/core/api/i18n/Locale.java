package pl.bmstefanski.xanax.core.api.i18n;

import org.bukkit.entity.Player;

public enum Locale {

  POLISH("pl_PL", "Polski", "Polska"),
  ENGLISH("en_US", "English", "United States");

  private final String localeCode;
  private final String localeName;

  private final String country;

  Locale(String localeCode, String localeName, String country) {
    this.localeCode = localeCode;
    this.localeName = localeName;
    this.country = country;
  }

  public String getLocaleCode() {
    return this.localeCode;
  }

  public String getLocaleName() {
    return this.localeName;
  }

  public String getCountry() {
    return this.country;
  }

  public static Locale getFromBukkitPlayer(Player player) {
    switch (player.getLocale()) {
      case "pl_PL":
        return Locale.POLISH;
      default:
      case "en_US":
        return Locale.ENGLISH;
    }
  }

}
