package pl.bmstefanski.xanax.core.drop;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.inventory.ItemStack;

@SerializableAs("Drop")
public class DropImpl implements Drop {

  private final String name;
  private final ItemStack item;
  private final double chance;
  private final float exp;
  private final float expReal;
  private final boolean fortune;

  private Set<Material> allowedTools;
  private Set<Biome> allowedBiomes;

  public DropImpl(String name, ItemStack item, double chance, float exp, float expReal,
      boolean fortune) {
    this.name = name;
    this.item = item;
    this.chance = chance;
    this.exp = exp;
    this.expReal = expReal;
    this.fortune = fortune;
  }

  public DropImpl(Map<String, Object> map) {
    this.name = (String) map.get("name");
    this.item = (ItemStack) map.get("item");
    this.chance = (double) map.get("chance");
    this.exp = (float) map.get("exp");
    this.expReal = (float) map.get("expReal");
    this.fortune = (boolean) map.get("fortune");
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public ItemStack getItem() {
    return item;
  }

  @Override
  public double getChance() {
    return chance;
  }

  @Override
  public float getExp() {
    return exp;
  }

  @Override
  public float getExpReal() {
    return expReal;
  }

  @Override
  public boolean isFortune() {
    return fortune;
  }

  @Override
  public Map<String, Object> serialize() {
    LinkedHashMap<String, Object> map = new LinkedHashMap<>();
    map.put("name", this.name);
    map.put("item", this.item);
    map.put("chance", this.chance);
    map.put("exp", this.exp);
    map.put("expReal", this.expReal);
    map.put("fortune", this.fortune);

    return map;
  }

  public static Drop deserialize(Map<String, Object> map) {
    return new DropImpl(map);
  }

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof Drop)) {
      return false;
    }

    Drop drop = (Drop) object;
    return Objects.equals(this.name, drop.getName()) &&
        Objects.equals(this.chance, drop.getChance()) &&
        Objects.equals(this.exp, drop.getExp()) &&
        Objects.equals(this.expReal, drop.getExpReal()) &&
        Objects.equals(this.fortune, drop.isFortune());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.chance);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .appendSuper(super.toString())
        .append("name", this.name)
        .append("chance", this.chance)
        .append("item", this.item)
        .append("exp", this.expReal)
        .append("expReal", this.expReal)
        .append("fortune", this.fortune)
        .toString();
  }

}