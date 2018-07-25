package pl.bmstefanski.xanax.core.api.entity;

import java.util.Optional;
import java.util.UUID;
import pl.bmstefanski.xanax.core.api.helper.IdentifiableEntity;

public interface User extends IdentifiableEntity<UUID> {

  Optional<String> getName();

  void setName(String name);

}
