package pl.pgf.task.productsstore.web;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.pgf.task.productsstore.service.CategoryService;
import pl.pgf.task.productsstore.service.ProductService;
import pl.pgf.task.productsstore.web.mappers.CategoryDto;
import pl.pgf.task.productsstore.web.mappers.ProductDto;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/api/v1/production", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@ResponseBody()
public class ProductionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductionController.class);
    private final ProductService productService;
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

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Validated ProductDto productDto) {
        LOGGER.info("POST /api/v1/production/products {}", productDto.toString());
        ProductDto newProductDto = ProductDto.toProductDto(productService.createNewProduct(productDto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newProductDto.getId()).toUri();
        return ResponseEntity.created(location).body(newProductDto);
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        LOGGER.info("GET /api/v1/production/products");
        return ResponseEntity.ok(StreamSupport
                .stream(productService.getAllProducts().spliterator(), false)
                .map(product -> ProductDto .toProductDto(product))
                .collect(Collectors.toList()));
    }

    @GetMapping("/products/name/like={productName}")
    public ResponseEntity<List<ProductDto>> filterProductByName(@PathVariable(value = "productName") String productName) {
        LOGGER.info("GET /api/v1/production/products/name/like={}", productName);
        return ResponseEntity.ok(StreamSupport
                .stream(productService.filterProductsByName(productName).spliterator(), false)
                .map(product -> ProductDto.toProductDto(product))
                .collect(Collectors.toList()));
    }

    @GetMapping("/products/name/{productName}")
    public ResponseEntity<ProductDto> getProductByName(@PathVariable(value = "productName") String productName) {
        LOGGER.info("GET /api/v1/production/products/name/{}", productName);
        return ResponseEntity.ok(ProductDto.toProductDto(productService.getProductsByName(productName)));
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductDto> getProductByName(@PathVariable(value = "productId") Integer productId) {
        LOGGER.info("GET /api/v1/production/products/{}", productId);
        return ResponseEntity.ok(ProductDto.toProductDto(productService.getProductById(productId)));
    }
}
