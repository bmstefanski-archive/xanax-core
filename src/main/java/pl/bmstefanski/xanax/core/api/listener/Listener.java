package pl.bmstefanski.xanax.core.api.listener;

import org.bukkit.event.Event;

public interface Listener<T extends Event> extends org.bukkit.event.Listener {

  void performEvent(T event);

}
