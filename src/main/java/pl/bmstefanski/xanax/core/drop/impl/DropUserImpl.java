package pl.bmstefanski.xanax.core.drop.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.bmstefanski.xanax.core.drop.DropUser;

public class DropUserImpl implements DropUser {

  private UUID uniqueId;
  private String name;
  private int level;
  private float exp;

  private final Map<ItemStack, Integer> droppedBlocks = new HashMap<>();

  public DropUserImpl(Player player) {
    this.uniqueId = player.getUniqueId();
    this.name = player.getName();
    this.level = 1;
  }

  @Override
  public UUID getIdentifier() {
    return uniqueId;
  }

  @Override
  public void setIdentifier(UUID identifier) {
    this.uniqueId = identifier;
  }

  @Override
  public Optional<String> getName() {
    return Optional.ofNullable(name);
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int getLevel() {
    return level;
  }

  @Override
  public void setLevel(int level) {
    this.level = level;
  }

  @Override
  public float getExp() {
    return exp;
  }

  @Override
  public void setExp(float exp) {
    this.exp = exp;
  }

  @Override
  public void addDroppedBlock(ItemStack item) {
    droppedBlocks.put(item, (droppedBlocks.getOrDefault(item, 0)) + 1);
  }

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof DropUser)) {
      return false;
    }

    DropUser dropUser = (DropUser) object;
    return Objects.equals(this.uniqueId, dropUser.getIdentifier()) &&
        Objects.equals(this.name, dropUser.getName().get()) &&
        Objects.equals(this.level, dropUser.getLevel()) &&
        Objects.equals(this.exp, dropUser.getExp());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.uniqueId, this.name, this.level, this.exp, this.droppedBlocks);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .appendSuper(super.toString())
        .append("uniqueId", this.uniqueId)
        .append("name", this.name)
        .append("level", this.level)
        .append("exp", this.exp)
        .append("droppedBlocks", this.droppedBlocks)
        .toString();
  }

}