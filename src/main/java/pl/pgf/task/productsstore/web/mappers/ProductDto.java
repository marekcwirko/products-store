package pl.pgf.task.productsstore.web.mappers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pgf.task.productsstore.domain.production.Product;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public final class ProductDto {
    private Integer id;
    private String name;
    private String brand;
    private String category;
    private String modelYear;
    private BigDecimal listPrice;

    public static ProductDto toProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getBrand().getName(),
                product.getCategory().getName(),
                product.getModelYear(),
                product.getListPrice());
    }
}
