package pl.bmstefanski.xanax.core.drop.helper;

import org.bukkit.ChatColor;

public final class ChatColorHelper {

  public static String colored(String toColoring) {
    return ChatColor.translateAlternateColorCodes('&', toColoring);
  }

  private ChatColorHelper() {
  }

}
