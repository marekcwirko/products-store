package pl.pgf.task.productsstore.repo;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.pgf.task.productsstore.domain.production.Brand;

public interface QBrandRepository extends BrandRepository, QuerydslPredicateExecutor<Brand> {
}
