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

package pl.bmstefanski.xanax.core;

import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.plugin.java.JavaPlugin;
import pl.bmstefanski.xanax.core.api.module.Module;
import pl.bmstefanski.xanax.core.api.module.impl.event.ModuleStartEvent;
import pl.bmstefanski.xanax.core.api.module.impl.event.ModuleStopEvent;
import pl.bmstefanski.xanax.core.api.module.PluginModule;
import pl.bmstefanski.xanax.core.api.module.impl.ModuleInitializer;
import pl.bmstefanski.xanax.core.guild.GuildModule;

public class XanaxCorePlugin extends JavaPlugin implements Listener {

  private Module guildModule;
  private Set<Module> modules;

  @Override
  public void onLoad() {
    this.guildModule = new GuildModule();
    this.modules = Stream.of(this.guildModule).collect(Collectors.toSet());
  }

  @Override
  public void onEnable() {
    ModuleInitializer.registerModule(this.guildModule);

    this.modules.forEach(module -> Bukkit.getPluginManager().registerEvents(module, this));
    this.modulesAction(module -> Bukkit.getPluginManager().callEvent(new ModuleStartEvent(module)));
    this.getServer().getPluginManager().registerEvents(this, this);
  }

  @EventHandler(priority = EventPriority.LOWEST)
  public void onDisable(PluginDisableEvent event) {
    this.modulesAction(module -> Bukkit.getPluginManager().callEvent(new ModuleStopEvent(module)));
  }

  private void modulesAction(Consumer<? super PluginModule> action) {
    ModuleInitializer.getAllModules().forEach(action);
  }

}
