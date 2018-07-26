package pl.bmstefanski.xanax.core.drop;

import java.util.HashSet;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import pl.bmstefanski.xanax.core.drop.Drop;
import pl.bmstefanski.xanax.core.drop.DropManager;
import pl.bmstefanski.xanax.core.drop.helper.ChanceHelper;
import pl.bmstefanski.xanax.core.drop.helper.InventorySize;

public class DropManagerImpl implements DropManager {

  private final Set<Drop> drops = new HashSet<>();

  @Override
  public Drop getRandomDrop() {
    return ChanceHelper.getRandomChance(this.drops);
  }

  @Override
  public Inventory getDropInventory() {
    Inventory inventory = Bukkit.createInventory(
        null,
        InventorySize.fit(this.drops.size()),
        "Drop");

    this.drops.stream().map(Drop::getItem).forEach(inventory::addItem);
    return inventory;
  }

}