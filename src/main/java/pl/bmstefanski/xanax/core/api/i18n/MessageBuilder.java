package pl.bmstefanski.xanax.core.api.i18n;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;

public class MessageBuilder {

  private String message;

  MessageBuilder(String rawMessage) {
    this.message = rawMessage;
  }

  public MessageBuilder withField(String fieldName, String value) {
    this.message = StringUtils.replace(this.message, "{" + fieldName + "}", value);
    return this;
  }

  public MessageBuilder color() {
    this.message = ChatColor.translateAlternateColorCodes('&', this.message);
    return this;
  }

  public ReadyMessage target(MessageType messageType) {
    return new ReadyMessage(this.message, messageType);
  }

  @Override
  public String toString() {
    return this.message;
  }

}
