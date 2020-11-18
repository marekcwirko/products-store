package pl.pgf.task.productsstore.domain.production;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "categories", schema = "production")
@Data
@Entity
@QueryEntity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name")
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
