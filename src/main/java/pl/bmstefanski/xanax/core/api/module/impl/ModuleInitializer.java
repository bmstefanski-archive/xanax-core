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

package pl.bmstefanski.xanax.core.api.module.impl;

import com.google.common.collect.ImmutableSet;
import java.util.LinkedHashSet;
import java.util.Set;
import pl.bmstefanski.xanax.core.api.module.Module;
import pl.bmstefanski.xanax.core.api.module.ModuleInfo;
import pl.bmstefanski.xanax.core.api.module.PluginModule;

public final class ModuleInitializer {

  private static final Set<PluginModule> MODULES = new LinkedHashSet<>();

  public static void registerModule(Module module) {
    Class<?> moduleClazz = module.getClass();

    if (moduleClazz.isAnnotationPresent(ModuleInfo.class)) {
      ModuleInfo moduleInfo = moduleClazz.getAnnotation(ModuleInfo.class);
      PluginModule pluginModule = new PluginModuleImpl(
          moduleInfo.name(),
          moduleInfo.version()
      );

      MODULES.add(pluginModule);
    }
  }

  public static ImmutableSet<PluginModule> getAllModules() {
    return ImmutableSet.copyOf(MODULES);
  }

  private ModuleInitializer() {
  }

}
