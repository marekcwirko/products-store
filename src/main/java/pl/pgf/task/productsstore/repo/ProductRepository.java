package pl.pgf.task.productsstore.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.pgf.task.productsstore.domain.production.Product;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Override
    @RestResource(exported = false)
    <S extends Product> S save(S s);

    @Override
    @RestResource(exported = false)
    <S extends Product> Iterable<S> saveAll(Iterable<S> iterable);

    @RestResource(exported = false)
    void deleteById(Integer s);

    @Override
    @RestResource(exported = false)
    void delete(Product player);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Product> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();

}
