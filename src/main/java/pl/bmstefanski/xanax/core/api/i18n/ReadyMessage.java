package pl.bmstefanski.xanax.core.api.i18n;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ReadyMessage {

  private final String message;
  private final MessageType messageType;

  ReadyMessage(String message, MessageType messageType) {
    this.message = message;
    this.messageType = messageType;
  }

  public void sendTo(Player player) {
    switch (this.messageType) {
      case ACTIONBAR:
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(this.message));
        break;
      case TITLE:
        player.sendTitle(this.message, "", -1, -1, -1);
        break;
      case SUB_TITLE:
        player.sendTitle("", this.message, -1, -1, -1);
        break;
      default:
      case CHAT:
        player.sendMessage(this.message);
    }
  }

}
