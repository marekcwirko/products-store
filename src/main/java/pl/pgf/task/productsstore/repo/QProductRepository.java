package pl.pgf.task.productsstore.repo;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.pgf.task.productsstore.domain.production.Product;

public interface QProductRepository extends ProductRepository, QuerydslPredicateExecutor<Product> {
}
