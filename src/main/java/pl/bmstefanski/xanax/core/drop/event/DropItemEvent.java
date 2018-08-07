package pl.bmstefanski.xanax.core.drop.event;

import pl.bmstefanski.xanax.core.api.event.CustomEvent;
import pl.bmstefanski.xanax.core.drop.entity.Drop;
import pl.bmstefanski.xanax.core.drop.entity.DropUser;

public class DropItemEvent extends CustomEvent {

  private final DropUser dropUser;
  private final Drop drop;

  public DropItemEvent(DropUser dropUser, Drop drop) {
    this.dropUser = dropUser;
    this.drop = drop;
  }

  public DropUser getDropUser() {
    return dropUser;
  }

  public Drop getDrop() {
    return drop;
  }

}