package pl.pgf.task.productsstore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pgf.task.productsstore.domain.production.Brand;
import pl.pgf.task.productsstore.domain.production.QBrand;
import pl.pgf.task.productsstore.domain.sales.QStore;
import pl.pgf.task.productsstore.domain.sales.Store;
import pl.pgf.task.productsstore.repo.QBrandRepository;
import pl.pgf.task.productsstore.repo.QStoreRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StoreService {

    private final QStoreRepository qStoreRepository;

    public Store getStoreById(Integer storeId) {
        return verifyStore(storeId);
    }

    private Store verifyStore(Integer storeId) throws NoSuchElementException {
        return qStoreRepository.findOne(QStore.store.id.eq(storeId))
                .orElseThrow(() -> new NoSuchElementException("Store(" + storeId));
    }

}