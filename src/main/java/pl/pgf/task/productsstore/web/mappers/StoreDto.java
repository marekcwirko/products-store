package pl.pgf.task.productsstore.web.mappers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pgf.task.productsstore.domain.sales.Store;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public final class StoreDto {
    private Integer id;
    private String storeName;
    private String phone;
    private String email;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public static StoreDto toStoreDto(Store store) {
        return new StoreDto(
                store.getId(),
                store.getStoreName(),
                store.getPhone(),
                store.getEmail(),
                store.getStreet(),
                store.getCity(),
                store.getState(),
                store.getZipCode());
    }
}
