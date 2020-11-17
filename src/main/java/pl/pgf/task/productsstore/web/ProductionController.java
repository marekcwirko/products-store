package pl.pgf.task.productsstore.web;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.pgf.task.productsstore.service.ProductionService;
import pl.pgf.task.productsstore.web.mappers.CategoryDto;
import pl.pgf.task.productsstore.web.mappers.ProductionMapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/api/v1/production", produces = MediaType.APPLICATION_JSON_VALUE)
//@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@ResponseBody()
public class ProductionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductionController.class);
    private final ProductionService productionService;
    private final ProductionMapper productionMapper;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        LOGGER.info("GET /api/v1/production/categories");
        return ResponseEntity.ok(StreamSupport
                .stream(productionService.getAllCategories().spliterator(), false)
                .map(category -> productionMapper.toCategoryDto(category))
                .collect(Collectors.toList()));
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable(value = "categoryId") Integer categoryId) {
        LOGGER.info("GET /api/v1/production/categories/{}", categoryId);
        return ResponseEntity.ok(productionMapper.toCategoryDto(productionService.getCategoryById(categoryId)));
    }

    @GetMapping("/categories/name/{categoryName}")
    public ResponseEntity<CategoryDto> getCategoryByName(@PathVariable(value = "categoryName") String categoryName) {
        LOGGER.info("GET /api/v1/production/categories/name/{}", categoryName);
        return ResponseEntity.ok(productionMapper.toCategoryDto(productionService.queryCategoryByName(categoryName)));
    }
}
