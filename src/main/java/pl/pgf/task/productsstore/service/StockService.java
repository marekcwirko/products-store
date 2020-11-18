package pl.pgf.task.productsstore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pgf.task.productsstore.domain.production.QStock;
import pl.pgf.task.productsstore.domain.production.Stock;
import pl.pgf.task.productsstore.repo.QStockRepository;
import pl.pgf.task.productsstore.web.mappers.ProductDto;
import pl.pgf.task.productsstore.web.mappers.ProductOnStockDto;

import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class StockService {

    private final QStockRepository qStockRepository;
    private final ProductService productService;

    public ProductOnStockDto checkProductAmountById(Integer productId) {
        ProductDto productDto = ProductDto.toProductDto(productService.getProductById(productId));
        Integer amount = StreamSupport.stream(
                qStockRepository.findAll(QStock.stock.product().product.id.eq(productId)).spliterator(), true)
                .map(pos -> pos.getQuantity())
                .reduce(0, (f, s) -> f + s);
        return new ProductOnStockDto(productDto, amount);
    }

}