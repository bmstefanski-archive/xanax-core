package pl.bmstefanski.xanax.core.drop.entity;

import org.bukkit.inventory.ItemStack;
import pl.bmstefanski.xanax.core.api.entity.User;

public interface DropUser extends User {

  int getLevel();

  void setLevel(int level);

  float getExp();

  void setExp(float exp);

  void addDroppedBlock(ItemStack item);

}