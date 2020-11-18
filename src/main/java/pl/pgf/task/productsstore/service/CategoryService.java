package pl.pgf.task.productsstore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pgf.task.productsstore.domain.production.Category;
import pl.pgf.task.productsstore.domain.production.QCategory;
import pl.pgf.task.productsstore.repo.QCategoryRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private final QCategoryRepository qCategoryRepository;

    public Iterable<Category> getAllCategories() {
        return qCategoryRepository.findAll();
    }

    public Category getCategoryById(Integer categoryId) {
        return verifyCategory(categoryId);
    }

    public Category queryCategoryByName(String categoryName) {
        Optional<Category> category = qCategoryRepository.findOne(QCategory.category.name.eq(categoryName));
        return category.orElseThrow(() -> new NoSuchElementException("Category(" + categoryName));
    }

    public Iterable<Category> filterCategoryByName(String categoryName) {
        return qCategoryRepository.findAll(QCategory.category.name.like(categoryName));
    }

    //    @Transactional()
    private Category verifyCategory(Integer categoryId) throws NoSuchElementException {
        return qCategoryRepository.findById(categoryId).orElseThrow(
                () -> new NoSuchElementException("Category(" + categoryId + ")"));
    }

}