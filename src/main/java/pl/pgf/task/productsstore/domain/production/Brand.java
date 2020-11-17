package pl.pgf.task.productsstore.domain.production;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "brands", schema = "production")
@Data
@Entity
@QueryEntity
@EqualsAndHashCode
@NoArgsConstructor
public class Brand implements Serializable {

    @Id
    @Column(name = "brand_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brand_name")
    private String name;

    public Brand(String name) {
        this.name = name;
    }
}
