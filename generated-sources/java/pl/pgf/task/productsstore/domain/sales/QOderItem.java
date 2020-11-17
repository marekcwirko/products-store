package pl.pgf.task.productsstore.domain.sales;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOderItem is a Querydsl query type for OderItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOderItem extends EntityPathBase<OderItem> {

    private static final long serialVersionUID = 274590712L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOderItem oderItem = new QOderItem("oderItem");

    public final NumberPath<java.math.BigDecimal> discount = createNumber("discount", java.math.BigDecimal.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<java.math.BigDecimal> listPrice = createNumber("listPrice", java.math.BigDecimal.class);

    protected QOrder order;

    protected pl.pgf.task.productsstore.domain.production.QProduct product;

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public QOderItem(String variable) {
        this(OderItem.class, forVariable(variable), INITS);
    }

    public QOderItem(Path<? extends OderItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOderItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOderItem(PathMetadata metadata, PathInits inits) {
        this(OderItem.class, metadata, inits);
    }

    public QOderItem(Class<? extends OderItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.order = inits.isInitialized("order") ? new QOrder(forProperty("order"), inits.get("order")) : null;
        this.product = inits.isInitialized("product") ? new pl.pgf.task.productsstore.domain.production.QProduct(forProperty("product"), inits.get("product")) : null;
    }

    public QOrder order() {
        if (order == null) {
            order = new QOrder(forProperty("order"));
        }
        return order;
    }

    public pl.pgf.task.productsstore.domain.production.QProduct product() {
        if (product == null) {
            product = new pl.pgf.task.productsstore.domain.production.QProduct(forProperty("product"));
        }
        return product;
    }

}

