package pl.pgf.task.productsstore.repo;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.pgf.task.productsstore.domain.sales.Store;

public interface QStoreRepository extends StoreRepository, QuerydslPredicateExecutor<Store> {
}
