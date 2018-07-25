package pl.bmstefanski.xanax.core.api.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandInfo {

  String value();

  String description() default "";

  String usage() default "";

  String permission() default "";

  String[] aliases() default {};

  int minArguments() default 0;

  int maxArguments() default 0;

}
