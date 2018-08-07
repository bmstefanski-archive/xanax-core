package pl.bmstefanski.xanax.core.drop.manager.impl;

import org.bukkit.entity.Player;
import pl.bmstefanski.xanax.core.api.manager.AbstractUserManager;
import pl.bmstefanski.xanax.core.drop.entity.DropUser;
import pl.bmstefanski.xanax.core.drop.entity.impl.DropUserImpl;
import pl.bmstefanski.xanax.core.drop.manager.DropUserManager;

public class DropUserManagerImpl extends AbstractUserManager<DropUser> implements DropUserManager {

  @Override
  public DropUser create(Player player) {
    DropUser user = new DropUserImpl(player);
    this.addUser(user);

    return user;
  }

  @Override
  public DropUser get(Player player) {
    return getUser(player).orElse(create(player));
  }

}