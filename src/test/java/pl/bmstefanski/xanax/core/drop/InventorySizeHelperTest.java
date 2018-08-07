package pl.bmstefanski.xanax.core.drop;

import java.util.concurrent.ThreadLocalRandom;
import org.junit.Assert;
import org.junit.Test;
import pl.bmstefanski.xanax.core.drop.helper.InventorySize;

public class InventorySizeHelperTest {

  @Test
  public void testFit() {
    for (int i = 0; i < 30; i++) {
      int a = ThreadLocalRandom.current().nextInt(1, 120);
      int fit = InventorySize.fit(a);

      Assert.assertTrue(fit >= 9);
      Assert.assertTrue(fit <= 54);
    }
  }

}