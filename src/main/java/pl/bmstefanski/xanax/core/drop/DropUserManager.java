package pl.bmstefanski.xanax.core.drop;

import org.bukkit.entity.Player;
import pl.bmstefanski.xanax.core.api.manager.UserManager;

public interface DropUserManager extends UserManager<DropUser> {

  DropUser create(Player player);

  DropUser get(Player player);

}
