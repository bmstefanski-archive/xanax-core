package pl.bmstefanski.xanax.core.api.command.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import pl.bmstefanski.xanax.core.api.bean.impl.BeanContainerInitializer;
import pl.bmstefanski.xanax.core.api.command.Command;
import pl.bmstefanski.xanax.core.api.command.CommandArguments;
import pl.bmstefanski.xanax.core.api.command.CommandExecutor;
import pl.bmstefanski.xanax.core.api.command.CommandInfo;

public final class CommandInitializer {

  private static CommandMap COMMAND_MAP;

  static {
    try {
      Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
      field.setAccessible(true);
      COMMAND_MAP = ((CommandMap) field.get(Bukkit.getServer()));
    } catch (IllegalAccessException | NoSuchFieldException e) {
      e.printStackTrace();
    }
  }

  public static void initialize(String packageName) {
    Reflections reflections = new Reflections(packageName, new MethodAnnotationsScanner());
    Set<Method> methods = reflections.getMethodsAnnotatedWith(CommandInfo.class);

    methods.forEach(method -> {
      CommandInfo commandAnnotation = method.getAnnotation(CommandInfo.class);

      Command command = new CommandBuilder()
          .withName(commandAnnotation.value())
          .withDescription(commandAnnotation.description())
          .withUsage(commandAnnotation.usage())
          .withPermission(commandAnnotation.permission())
          .withMinArguments(commandAnnotation.minArguments())
          .withMaxArguments(commandAnnotation.maxArguments())
          .withAliases(Arrays.asList(commandAnnotation.aliases()))
          .build();

      org.bukkit.command.Command bukkitCommand = new BukkitCommand(
          command.getName(),
          command.getDescription(),
          command.getUsage(),
          command.getAliases()) {

        @Override
        public boolean execute(CommandSender commandSender, String s, String[] strings) {

          CommandArguments commandArguments = new CommandArgumentsImpl(Stream
              .of(strings)
              .collect(Collectors.toList())
          );

          if (!commandSender.hasPermission(command.getPermission()) && !command.getPermission().isEmpty()) {
            commandSender
                .sendMessage(ChatColor.RED + "Nie masz uprawnien do wykonania tego polecenia! "
                    + ChatColor.GRAY + "(" + command.getPermission() + ")");
            return true;
          }

          if ((commandArguments.getAll().size() < command.getMinArguments()) || (
              commandArguments.getAll().size() > command.getMaxArguments())) {
            commandSender
                .sendMessage(ChatColor.RED + "Poprawne uzycie komendy: " + ChatColor.GRAY + "/"
                    + command.getName() + " " + command.getUsage());
            return true;
          }

          CommandExecutor commandExecutor = (CommandExecutor) BeanContainerInitializer
              .getBeansInstances().get(method.getDeclaringClass().getName());
          commandExecutor.execute(commandSender, commandArguments);
          return true;
        }
      };

      COMMAND_MAP.register(command.getName(), bukkitCommand);
    });
  }

  private CommandInitializer() {
  }

}
