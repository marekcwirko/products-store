package pl.pgf.task.productsstore.web.mappers;

import org.springframework.stereotype.Service;
import pl.pgf.task.productsstore.domain.production.Category;

@Service
public class ProductionMapper {
    public CategoryDto toCategoryDto(Category c) {
        return new CategoryDto(c.getName());
    }
}
