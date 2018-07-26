package pl.bmstefanski.xanax.core.drop;

import org.bukkit.inventory.Inventory;

public interface DropManager {

  Drop getRandomDrop();

  Inventory getDropInventory();

}