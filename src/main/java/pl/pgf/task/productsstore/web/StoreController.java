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
import pl.pgf.task.productsstore.service.StoreService;
import pl.pgf.task.productsstore.web.mappers.StoreDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/api/v1/production", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@ResponseBody()
public class StoreController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);
    private final StoreService storeService;

    @GetMapping("/stores")
    public ResponseEntity<List<StoreDto>> getAllStores() {
        LOGGER.info("GET /api/v1/production/stores");
        return ResponseEntity.ok(StreamSupport
                .stream(storeService.getAllStores().spliterator(), false)
                .map(store -> StoreDto.toStoreDto(store))
                .collect(Collectors.toList()));
    }

}
