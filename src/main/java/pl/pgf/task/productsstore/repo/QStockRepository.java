package pl.pgf.task.productsstore.repo;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.pgf.task.productsstore.domain.production.Stock;

public interface QStockRepository extends BrandRepository, QuerydslPredicateExecutor<Stock> {
}
