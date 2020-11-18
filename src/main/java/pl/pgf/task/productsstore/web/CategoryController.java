package pl.pgf.task.productsstore.web;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pgf.task.productsstore.service.CategoryService;
import pl.pgf.task.productsstore.web.mappers.CategoryDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/api/v1/production", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@ResponseBody()
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        LOGGER.info("GET /api/v1/production/categories");
        return ResponseEntity.ok(StreamSupport
                .stream(categoryService.getAllCategories().spliterator(), false)
                .map(category -> CategoryDto.toCategoryDto(category))
                .collect(Collectors.toList()));
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable(value = "categoryId") Integer categoryId) {
        LOGGER.info("GET /api/v1/production/categories/{}", categoryId);
        return ResponseEntity.ok(CategoryDto.toCategoryDto(categoryService.getCategoryById(categoryId)));
    }

    @GetMapping("/categories/name/{categoryName}")
    public ResponseEntity<CategoryDto> getCategoryByName(@PathVariable(value = "categoryName") String categoryName) {
        LOGGER.info("GET /api/v1/production/categories/name/{}", categoryName);
        return ResponseEntity.ok(CategoryDto.toCategoryDto(categoryService.queryCategoryByName(categoryName)));
    }

    @GetMapping("/categories/name/like={categoryName}")
    public ResponseEntity<List<CategoryDto>> filterCategoryByName(@PathVariable(value = "categoryName") String categoryName) {
        LOGGER.info("GET /api/v1/production/categories/name/like={}", categoryName);
        return ResponseEntity.ok(StreamSupport
                .stream(categoryService.filterCategoryByName(categoryName).spliterator(), false)
                .map(category -> CategoryDto.toCategoryDto(category))
                .collect(Collectors.toList()));
    }

}
