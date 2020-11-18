package pl.pgf.task.productsstore.domain.sales;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import pl.pgf.task.productsstore.domain.production.Product;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "order_items", schema = "sales")
@Data
@Entity
@QueryEntity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OderItem implements Serializable {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "list_price")
    private BigDecimal listPrice;

    @Column(name = "discount")
    private BigDecimal discount;
}
