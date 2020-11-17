package pl.pgf.task.productsstore.domain.production;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = 78302683L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    protected QBrand brand;

    protected QCategory category;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<java.math.BigDecimal> listPrice = createNumber("listPrice", java.math.BigDecimal.class);

    public final StringPath modelYear = createString("modelYear");

    public final StringPath name = createString("name");

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.brand = inits.isInitialized("brand") ? new QBrand(forProperty("brand")) : null;
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category")) : null;
    }

    public QBrand brand() {
        if (brand == null) {
            brand = new QBrand(forProperty("brand"));
        }
        return brand;
    }

    public QCategory category() {
        if (category == null) {
            category = new QCategory(forProperty("category"));
        }
        return category;
    }

}

