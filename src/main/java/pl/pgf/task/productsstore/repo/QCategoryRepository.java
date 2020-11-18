package pl.pgf.task.productsstore.repo;


import pl.pgf.task.productsstore.domain.production.Category;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QCategoryRepository extends CategoryRepository, QuerydslPredicateExecutor <Category> {
}
