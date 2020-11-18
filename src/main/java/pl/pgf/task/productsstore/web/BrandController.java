package pl.pgf.task.productsstore.web;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.pgf.task.productsstore.service.BrandService;
import pl.pgf.task.productsstore.web.mappers.BrandDto;
import pl.pgf.task.productsstore.web.mappers.CategoryDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/api/v1/production", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@ResponseBody()
public class BrandController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrandController.class);
    private final BrandService brandService;

    @GetMapping("/brands")
    public ResponseEntity<List<BrandDto>> getAllBrands() {
        LOGGER.info("GET /api/v1/production/brands");
        return ResponseEntity.ok(StreamSupport
                .stream(brandService.getAllBrands().spliterator(), false)
                .map(brand -> BrandDto.toBrandDto(brand))
                .collect(Collectors.toList()));
    }

}
