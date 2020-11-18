package pl.pgf.task.productsstore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pgf.task.productsstore.domain.production.Brand;
import pl.pgf.task.productsstore.domain.production.QBrand;
import pl.pgf.task.productsstore.repo.QBrandRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService {

    private final QBrandRepository qBrandRepository;

    public Brand queryBrandByName(String brandName) {
        Optional<Brand> brand = qBrandRepository.findOne(QBrand.brand.name.eq(brandName));
        return brand.orElseThrow(() -> new NoSuchElementException("Brand(" + brandName));
    }

}