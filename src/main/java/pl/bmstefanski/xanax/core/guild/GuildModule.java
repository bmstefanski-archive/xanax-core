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

package pl.bmstefanski.xanax.core.guild;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pl.bmstefanski.xanax.core.XanaxCorePlugin;
import pl.bmstefanski.xanax.core.api.bean.impl.BeanContainerInitializer;
import pl.bmstefanski.xanax.core.api.command.impl.CommandInitializer;
import pl.bmstefanski.xanax.core.api.module.impl.event.ModuleStartEvent;
import pl.bmstefanski.xanax.core.api.module.impl.event.ModuleStopEvent;
import pl.bmstefanski.xanax.core.api.listener.impl.ListenerInitializer;
import pl.bmstefanski.xanax.core.api.module.Module;
import pl.bmstefanski.xanax.core.api.module.ModuleInfo;

@ModuleInfo(name = "guild", version = "0.0.2")
public class GuildModule implements Module {

  private static final String MODULE_PACKAGE_SCOPE = "pl.bmstefanski.xanax.core.guild";

  @EventHandler(priority = EventPriority.LOWEST)
  @Override
  public void onStart(ModuleStartEvent event) {
    BeanContainerInitializer.initialize(MODULE_PACKAGE_SCOPE, this);
    ListenerInitializer.initialize(this.getPlugin(), MODULE_PACKAGE_SCOPE + ".listener");
    CommandInitializer.initialize(MODULE_PACKAGE_SCOPE + ".command");
  }

  @EventHandler(priority = EventPriority.LOWEST)
  @Override
  public void onStop(ModuleStopEvent event) {

  }

  @Override
  public Plugin getPlugin() {
    return JavaPlugin.getPlugin(XanaxCorePlugin.class);
  }

}
