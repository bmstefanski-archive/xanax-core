package pl.bmstefanski.xanax.core.drop.manager;

import org.bukkit.inventory.Inventory;
import pl.bmstefanski.xanax.core.drop.entity.Drop;

public interface DropManager {

  Drop getRandomDrop();

  Inventory getDropInventory();

}