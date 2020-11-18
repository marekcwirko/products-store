package pl.pgf.task.productsstore.domain.production;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStock is a Querydsl query type for Stock
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStock extends EntityPathBase<Stock> {

    private static final long serialVersionUID = -1668594942L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStock stock = new QStock("stock");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    protected QProduct product;

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    protected pl.pgf.task.productsstore.domain.sales.QStore store;

    public QStock(String variable) {
        this(Stock.class, forVariable(variable), INITS);
    }

    public QStock(Path<? extends Stock> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStock(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStock(PathMetadata metadata, PathInits inits) {
        this(Stock.class, metadata, inits);
    }

    public QStock(Class<? extends Stock> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
        this.store = inits.isInitialized("store") ? new pl.pgf.task.productsstore.domain.sales.QStore(forProperty("store")) : null;
    }

    public QProduct product() {
        if (product == null) {
            product = new QProduct(forProperty("product"));
        }
        return product;
    }

    public pl.pgf.task.productsstore.domain.sales.QStore store() {
        if (store == null) {
            store = new pl.pgf.task.productsstore.domain.sales.QStore(forProperty("store"));
        }
        return store;
    }

}

