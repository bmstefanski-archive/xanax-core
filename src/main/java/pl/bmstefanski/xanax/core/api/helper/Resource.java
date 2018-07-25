package pl.bmstefanski.xanax.core.api.helper;

public interface Resource<T extends IdentifiableEntity<?>> {

  void load();

  void save(T entity);

  void checkTable();

}
