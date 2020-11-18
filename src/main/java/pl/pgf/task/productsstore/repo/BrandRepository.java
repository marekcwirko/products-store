package pl.pgf.task.productsstore.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.pgf.task.productsstore.domain.production.Brand;

@RepositoryRestResource(collectionResourceRel = "brands", path = "brands")
public interface BrandRepository extends CrudRepository<Brand, Integer> {

    @Override
    @RestResource(exported = false)
    <S extends Brand> S save(S s);

    @Override
    @RestResource(exported = false)
    <S extends Brand> Iterable<S> saveAll(Iterable<S> iterable);

    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @RestResource(exported = false)
    void delete(Brand player);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Brand> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();

}
