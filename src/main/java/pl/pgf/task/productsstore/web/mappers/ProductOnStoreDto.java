package pl.pgf.task.productsstore.web.mappers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public final class ProductOnStoreDto {
    private ProductDto product;
    private StoreDto store;
    private Integer amount;
}
