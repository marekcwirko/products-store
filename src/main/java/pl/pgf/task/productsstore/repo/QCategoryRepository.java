package pl.pgf.task.productsstore.repo;

import pl.pgf.task.productsstore.domain.Category;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QCategoryRepository extends CategoryRepository, QuerydslPredicateExecutor <Category> {
}
