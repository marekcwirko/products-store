package pl.pgf.task.productsstore.domain.production;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import pl.pgf.task.productsstore.domain.sales.Store;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "stocks", schema = "production")
@Data
@Entity
@QueryEntity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Stock implements Serializable {

    @Id
    @Column(name = "stock_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(name = "quantity")
    private Integer quantity;

}
