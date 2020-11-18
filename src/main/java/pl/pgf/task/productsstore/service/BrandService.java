package pl.pgf.task.productsstore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pgf.task.productsstore.domain.production.Brand;
import pl.pgf.task.productsstore.domain.production.Category;
import pl.pgf.task.productsstore.domain.production.QBrand;
import pl.pgf.task.productsstore.repo.QBrandRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService {

    private final QBrandRepository qBrandRepository;

    public Brand queryBrandByName(String brandName) {
        return qBrandRepository.findOne(QBrand.brand.name.eq(brandName))
            .orElseThrow(() -> new NoSuchElementException("Brand(" + brandName));
    }

    private Brand verifyBrand(Integer brandId) throws NoSuchElementException {
        return qBrandRepository.findById(brandId).orElseThrow(
                () -> new NoSuchElementException("Brand(" + brandId + ")"));
    }

    public Iterable<Brand> getAllBrands() {
        return qBrandRepository.findAll();
    }

}