package pl.bmstefanski.xanax.core.drop.helper;

import java.util.Arrays;
import java.util.Comparator;

public enum InventorySize {

  ONE(9),
  TWO(18),
  THREE(27),
  FOUR(36),
  FIVE(45),
  SIX(54);

  private final int size;

  InventorySize(int size) {
    this.size = Helper.fit(size);
  }

  public static int parse(String size) {
    int i = 0;
    try {
      i = Integer.parseInt(size);
    } catch (NumberFormatException e) {
      for (InventorySize inventorySize : values()) {
        if (inventorySize.name().equalsIgnoreCase(size)) {
          i = inventorySize.size;
        }
      }
    }

    return i;
  }

  public static int parseOrDefault(String size, int defaultSize) {
    int sizeParser = parse(size);
    return sizeParser == 0 ? Helper.fit(defaultSize) : sizeParser;
  }

  public static int fit(int size) {
    return Helper.fit(size);
  }

  public int getSize() {
    return size;
  }

  static final class Helper {

    static final int[] allowNumbers = {9, 18, 27, 36, 45, 54};

    static int fit(int size) {
      return Arrays.stream(allowNumbers)
          .boxed()
          .min(Comparator.comparingInt(i -> Math.abs(i - size)))
          .get();
    }

    private Helper() {
    }
  }

}