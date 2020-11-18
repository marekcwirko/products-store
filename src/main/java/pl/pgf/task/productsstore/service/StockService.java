package pl.pgf.task.productsstore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pgf.task.productsstore.domain.production.*;
import pl.pgf.task.productsstore.domain.sales.QStore;
import pl.pgf.task.productsstore.domain.sales.Store;
import pl.pgf.task.productsstore.repo.QProductRepository;
import pl.pgf.task.productsstore.repo.QStockRepository;
import pl.pgf.task.productsstore.web.mappers.ProductDto;
import pl.pgf.task.productsstore.web.mappers.ProductOnStockDto;
import pl.pgf.task.productsstore.web.mappers.ProductOnStoreDto;
import pl.pgf.task.productsstore.web.mappers.StoreDto;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class StockService {

    private final QStockRepository qStockRepository;
    private final ProductService productService;
    private final StoreService storeService;

    public ProductOnStockDto checkProductAmountById(Integer productId) {
        ProductDto productDto = ProductDto.toProductDto(productService.getProductById(productId));
        Integer amount = StreamSupport.stream(
                qStockRepository.findAll(QStock.stock.product().product.id.eq(productId)).spliterator(), true)
                .map(pos -> pos.getQuantity())
                .reduce(0, (f, s) -> f + s);
        return new ProductOnStockDto(productDto, amount);
    }

    public ProductOnStoreDto updateProductOnStockForStore(Integer productId, Integer storeId, Integer newAmount) {
        Product product = productService.getProductById(productId);
        Store store = storeService.getStoreById(storeId);
        Optional<Stock> stockOpt = qStockRepository.findOne(
                QProduct.product.id.eq(productId)
                        .and(QStore.store.id.eq(storeId)));
        Stock stock = stockOpt.orElse(new Stock(0, product, store, 0));
        stock.setQuantity(newAmount);
        qStockRepository.save(stock);
        return new ProductOnStoreDto(
                ProductDto.toProductDto(product),
                StoreDto.toStoreDto(store),
                newAmount);
    }
}