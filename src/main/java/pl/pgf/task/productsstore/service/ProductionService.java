package pl.pgf.task.productsstore.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.pgf.task.productsstore.domain.Category;
import pl.pgf.task.productsstore.repo.CategoryRepository;

@Service
@AllArgsConstructor
public class ProductionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductionService.class);
    private final CategoryRepository categoryRepository;

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
