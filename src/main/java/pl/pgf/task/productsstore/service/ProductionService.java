package pl.pgf.task.productsstore.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.pgf.task.productsstore.domain.Category;
import pl.pgf.task.productsstore.domain.QCategory;
import pl.pgf.task.productsstore.repo.CategoryRepository;
import pl.pgf.task.productsstore.repo.QCategoryRepository;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ProductionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductionService.class);
    private final CategoryRepository categoryRepository;
    private final QCategoryRepository qCategoryRepository;

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer categoryId) {
        return verifyCategory(categoryId);
    }

    public Category queryCategoryByName(String categoryName) {
        Iterable<Category> categories = qCategoryRepository.findAll(QCategory.category.name.eq(categoryName));
        Optional<Category> category = StreamSupport.stream(categories.spliterator(), false).findFirst();
        return category.orElseThrow(() -> new NoSuchElementException("Category(" + categoryName));
    }

    private Category verifyCategory(Integer categoryId) throws NoSuchElementException {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new NoSuchElementException("Category(" + categoryId));
    }
}
