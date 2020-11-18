package pl.pgf.task.productsstore.web.mappers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pgf.task.productsstore.domain.production.Brand;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class BrandDto {

    private Integer id;
    private String name;

    public static BrandDto toBrandDto(Brand b) {
        return new BrandDto(b.getId(), b.getName());
    }
}
