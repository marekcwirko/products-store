package pl.pgf.task.productsstore.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.pgf.task.productsstore.domain.sales.Store;

@RepositoryRestResource(collectionResourceRel = "stores", path = "stores")
public interface StoreRepository extends CrudRepository<Store, Integer> {

    @Override
    @RestResource(exported = false)
    <S extends Store> S save(S s);

    @Override
    @RestResource(exported = false)
    <S extends Store> Iterable<S> saveAll(Iterable<S> iterable);

    @RestResource(exported = false)
    void deleteById(Integer s);

    @Override
    @RestResource(exported = false)
    void delete(Store player);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Store> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();

}
