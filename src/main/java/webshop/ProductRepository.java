package webshop;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private JdbcTemplate jdbcTemplate;

    public ProductRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public long insertProduct(String productName, int price, int stock){
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
                                @Override
                                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                                    PreparedStatement ps =
                                            connection.prepareStatement("insert into products(product_name,price,stock) values (?,?,?)",
                                                    Statement.RETURN_GENERATED_KEYS);
                                    ps.setString(1, productName);
                                    ps.setInt(2, price);
                                    ps.setInt(3, stock);
                                    return ps;
                                }
                            }, keyHolder
        );

        return    keyHolder.getKey().longValue();
    }

    public Product findProductById(long id) {
        List<Product> products=jdbcTemplate.query("select id,product_name,price,stock from products where id=?"
                , new ProductRowMapper()
                ,id);
        if(products.size()<1){
            throw new IllegalArgumentException("No produst found!");
        }
        return products.get(0);
    }

    public void updateProductStock(long id, int change) {
        String sql = "UPDATE products SET stock = stock-?  WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, change, id);
    }
}
