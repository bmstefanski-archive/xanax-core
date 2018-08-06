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

package pl.bmstefanski.xanax.core.api.manager;

import com.google.common.collect.ImmutableSet;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pl.bmstefanski.xanax.core.api.entity.User;

public abstract class AbstractUserManager<T extends User> implements UserManager<T> {

  private final ConcurrentMap<String, T> userNameMap = new ConcurrentHashMap<>(16, 0.9F, 1);
  private final ConcurrentMap<UUID, T> userUniqueIdMap = new ConcurrentHashMap<>(16, 0.9F, 1);

  @Override
  public Optional<T> getUser(String name) {
    Validate.notNull(name, "Player value cannot be null!");

    return this.userNameMap.values()
        .stream()
        .filter(user -> user.getName().get().equalsIgnoreCase(name))
        .findFirst();
  }

  @Override
  public Optional<T> getUser(UUID uniqueId) {
    Validate.notNull(uniqueId, "Player unique id cannot be null!");

    return this.userUniqueIdMap.values()
        .stream()
        .filter(user -> user.getIdentifier().equals(uniqueId))
        .findFirst();
  }

  @Override
  public Optional<T> getUser(Player player) {
    Validate.notNull(player, "Player object cannot be null!");

    return this.getUser(player.getUniqueId());
  }

  @Override
  public void addUser(T user) {
    Validate.notNull(user, "User object cannot be null!");

    this.userUniqueIdMap.put(user.getIdentifier(), user);
    if (user.getName().isPresent()) {
      this.userNameMap.put(user.getName().get(), user);
    }
  }

  @Override
  public void removeUser(T user) {
    Validate.notNull(user, "User object cannot be null!");

    this.userUniqueIdMap.remove(user.getIdentifier());
    this.userNameMap.remove(user.getName().get());
  }

  @Override
  public ImmutableSet<T> getOnlineUsers() {
    return ImmutableSet.copyOf(Bukkit.getServer().getOnlinePlayers().stream()
        .map(player -> this.getUser(player.getUniqueId()))
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toSet()));
  }

}