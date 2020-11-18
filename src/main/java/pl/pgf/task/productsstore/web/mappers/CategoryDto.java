package pl.pgf.task.productsstore.web.mappers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pgf.task.productsstore.domain.production.Category;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public final class CategoryDto {

    private String name;

    public static CategoryDto toCategoryDto(Category c) {
        return new CategoryDto(c.getName());
    }
}
