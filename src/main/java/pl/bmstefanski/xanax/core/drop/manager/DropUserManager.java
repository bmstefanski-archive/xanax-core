package pl.bmstefanski.xanax.core.drop.manager;

import org.bukkit.entity.Player;
import pl.bmstefanski.xanax.core.api.manager.UserManager;
import pl.bmstefanski.xanax.core.drop.entity.DropUser;

public interface DropUserManager extends UserManager<DropUser> {

  DropUser create(Player player);

  DropUser get(Player player);

}