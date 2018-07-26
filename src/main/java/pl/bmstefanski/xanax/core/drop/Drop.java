package pl.bmstefanski.xanax.core.drop;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

public interface Drop extends ConfigurationSerializable {

  String getName();

  ItemStack getItem();

  double getChance();

  float getExp();

  float getExpReal();

  boolean isFortune();

}
