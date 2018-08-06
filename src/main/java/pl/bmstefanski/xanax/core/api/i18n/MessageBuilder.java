/*
 * MIT License
 *
 * Copyright (c) 2018 Bartłomiej Stefański
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package pl.bmstefanski.xanax.core.api.i18n;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;

/*
 * @author jwiczkowsky
 * */

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
