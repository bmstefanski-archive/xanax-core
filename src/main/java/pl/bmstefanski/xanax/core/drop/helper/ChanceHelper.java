package pl.bmstefanski.xanax.core.drop.helper;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import pl.bmstefanski.xanax.core.drop.Drop;

public final class ChanceHelper {

  public static Drop getRandomChance(Set<Drop> drops) {
    double sumChance = sumChance(drops);
    double randomChance = ThreadLocalRandom.current().nextDouble(0, sumChance);

    for (Drop drop : drops) {
      randomChance -= drop.getChance();
      if (randomChance < 0) {
        return drop;
      }
    }

    return null;
  }

  private static double sumChance(Set<Drop> drops) {
    return drops.stream().mapToDouble(Drop::getChance).sum();
  }

  private ChanceHelper() {
  }

}