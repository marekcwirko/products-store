package pl.pgf.task.productsstore.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.pgf.task.productsstore.domain.production.Stock;

@RepositoryRestResource(collectionResourceRel = "stores", path = "stores")
public interface StockRepository extends CrudRepository<Stock, Integer> {

    @Override
    @RestResource(exported = false)
    <S extends Stock> S save(S s);

    @Override
    @RestResource(exported = false)
    <S extends Stock> Iterable<S> saveAll(Iterable<S> iterable);

    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @RestResource(exported = false)
    void delete(Stock player);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Stock> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();

}
