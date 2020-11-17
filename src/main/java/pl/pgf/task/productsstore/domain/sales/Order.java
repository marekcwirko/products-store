package pl.pgf.task.productsstore.domain.sales;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Table(name = "orders", schema = "sales")
@Data
@Entity
@QueryEntity
@EqualsAndHashCode
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    //Order status: 1 = Pending; 2 = Processing; 3 = Rejected; 4 = Completed
    @Column(name = "order_status")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderStatus;

    @Column(name = "order_date")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date orderDate;

    @Column(name = "required_date")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date requiredDate;

    @Column(name = "shipped_date")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date shippedDate;

    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;
}
