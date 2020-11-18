package pl.pgf.task.productsstore.web.mappers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class ProductOnStockDto {
    private ProductDto product;
    private Integer amount;
}
