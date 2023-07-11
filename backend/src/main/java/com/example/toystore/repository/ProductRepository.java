package com.example.toystore.repository;

import com.example.toystore.dto.Product;
import com.example.toystore.dto.ProductType;
import com.example.toystore.dto.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    private Sql2o dataSource;

    public int insertProduct(Product product){
        try (Connection con = dataSource.open()) {
            String stmt =
                    """
                            INSERT INTO products (id, name, qty, thumbnail, image, price, status, note, typeId, sourceId)
                            VALUES (:id, :name, :qty, :thumbnail, :image, :price, :status, :note, :typeId, :sourceId)
                    """;
            return con.createQuery(stmt)
                    .bind(product)
                    .executeUpdate()
                    .getKey(Integer.class);
        }
    }

    public int insertTypeProduct(ProductType product) {
        try (Connection con = dataSource.open()) {
            String stmt =
                    """
                            INSERT INTO product_types (name, status, note)
                            VALUES (:name, :status, :note)
                    """;
            return con.createQuery(stmt)
                    .bind(product)
                    .executeUpdate()
                    .getKey(Integer.class);
        }
    }

    public int insertProductSource(Source source) {
        try (Connection con = dataSource.open()) {
            String stmt =
                    """
                            INSERT INTO sources (name, status, note, phone, address)
                            VALUES (:name, :status, :note, :phone, :address)
                    """;
            return con.createQuery(stmt)
                    .bind(source)
                    .executeUpdate()
                    .getKey(Integer.class);
        }
    }

    public List<Product> getAllProduct() {
        try (Connection con = dataSource.open()) {
            String stmt =
                    """
                            SELECT p.id , p.name , p.qty , p.thumbnail , p.image, p.price , p.created  , p.updated, p.status, p.note, p.typeId, p.sourceId
                            FROM products p
                    """;
            return con.createQuery(stmt)
                    .executeAndFetch(Product.class);
        }
    }

    public List<ProductType> getAllProductType() {
        try (Connection con = dataSource.open()) {
            String stmt =
                    """
                            SELECT id, name, status, note, created, updated
                            FROM product_types
                    """;
            return con.createQuery(stmt)
                    .executeAndFetch(ProductType.class);
        }
    }

    public List<Source> getAllProductSource() {
        try (Connection con = dataSource.open()) {
            String stmt =
                    """
                            SELECT id, name, status, note, phone, address, created, updated
                            FROM sources
                    """;
            return con.createQuery(stmt)
                    .executeAndFetch(Source.class);
        }
    }
}
