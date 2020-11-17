package pl.pgf.task.productsstore.domain.sales;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = 393288107L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrder order = new QOrder("order1");

    protected QCustomer customer;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DatePath<java.sql.Date> orderDate = createDate("orderDate", java.sql.Date.class);

    public final NumberPath<Integer> orderStatus = createNumber("orderStatus", Integer.class);

    public final DatePath<java.sql.Date> requiredDate = createDate("requiredDate", java.sql.Date.class);

    public final DatePath<java.sql.Date> shippedDate = createDate("shippedDate", java.sql.Date.class);

    protected QStaff staff;

    protected QStore store;

    public QOrder(String variable) {
        this(Order.class, forVariable(variable), INITS);
    }

    public QOrder(Path<? extends Order> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrder(PathMetadata metadata, PathInits inits) {
        this(Order.class, metadata, inits);
    }

    public QOrder(Class<? extends Order> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customer = inits.isInitialized("customer") ? new QCustomer(forProperty("customer")) : null;
        this.staff = inits.isInitialized("staff") ? new QStaff(forProperty("staff"), inits.get("staff")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store")) : null;
    }

    public QCustomer customer() {
        if (customer == null) {
            customer = new QCustomer(forProperty("customer"));
        }
        return customer;
    }

    public QStaff staff() {
        if (staff == null) {
            staff = new QStaff(forProperty("staff"));
        }
        return staff;
    }

    public QStore store() {
        if (store == null) {
            store = new QStore(forProperty("store"));
        }
        return store;
    }

}

