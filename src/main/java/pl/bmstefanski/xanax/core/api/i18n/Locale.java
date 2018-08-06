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

import org.bukkit.entity.Player;

/*
 * @author jwiczkowsky
 * */

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
