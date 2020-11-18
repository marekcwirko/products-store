package pl.pgf.task.productsstore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pgf.task.productsstore.domain.production.Brand;
import pl.pgf.task.productsstore.domain.production.Category;
import pl.pgf.task.productsstore.domain.production.Product;
import pl.pgf.task.productsstore.domain.production.QProduct;
import pl.pgf.task.productsstore.repo.QProductRepository;
import pl.pgf.task.productsstore.web.mappers.ProductDto;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final CategoryService categoryService;
    private final BrandService brandService;
    private final QProductRepository qProductRepository;

    public Product createNewProduct(ProductDto productDto) {
        Category category = categoryService.queryCategoryByName(productDto.getCategory());
        Brand brand = brandService.queryBrandByName(productDto.getCategory());
        Product newProduct = new Product(0, productDto.getName(), brand, category,
                productDto.getModelYear(), productDto.getListPrice());
        qProductRepository.save(newProduct);
        return null;
    }

    public Iterable<Product> getAllProducts() {
        return qProductRepository.findAll();
    }

    public Iterable<Product> filterProductsByName(String productName) {
        return qProductRepository.findAll(QProduct.product.name.like(productName));
    }

    public Product getProductsByName(String productName) {
        Optional<Product> product = qProductRepository.findOne(QProduct.product.name.eq(productName));
        return product.orElseThrow(() -> new NoSuchElementException("Product(" + productName));
    }

    public Product getProductById(Integer productId) {
        return verifyProduct(productId);
    }

    private Product verifyProduct(Integer productId) throws NoSuchElementException {
        return qProductRepository.findById(productId).orElseThrow(
                () -> new NoSuchElementException("Product(" + productId + ")"));
    }

}