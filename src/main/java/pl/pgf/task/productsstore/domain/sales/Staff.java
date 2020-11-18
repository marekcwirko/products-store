package pl.pgf.task.productsstore.domain.sales;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "staffs", schema = "sales")
@Data
@Entity
@QueryEntity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Staff implements Serializable {

    @Id
    @Column(name = "staff_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "active")
    private Integer active;

    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id", nullable = false)
    private Staff manager;
}

