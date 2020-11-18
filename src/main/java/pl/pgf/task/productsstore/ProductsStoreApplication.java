package pl.pgf.task.productsstore;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductsStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsStoreApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Products Store API").version(appVersion));
    }

    @Bean
    public GroupedOpenApi productionApi() {
        return GroupedOpenApi.builder()
                .group("Products Store Production")
                .pathsToMatch("/api/v1/production/**")
                .build();
    }

    @Bean
    public GroupedOpenApi salesApi() {
        return GroupedOpenApi.builder()
                .group("Products Store Sales")
                .pathsToMatch("/api/v1/sales/**")
                .build();
    }

}
