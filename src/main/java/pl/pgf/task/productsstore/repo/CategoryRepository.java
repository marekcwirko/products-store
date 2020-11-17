package pl.pgf.task.productsstore.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.pgf.task.productsstore.domain.Category;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Override
    @RestResource(exported = false)
    <S extends Category> S save(S s);

    @Override
    @RestResource(exported = false)
    <S extends Category> Iterable<S> saveAll(Iterable<S> iterable);

    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @RestResource(exported = false)
    void delete(Category player);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Category> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();

//    Optional<Category> findCategoryByCategoryName(String categoryName);
}
