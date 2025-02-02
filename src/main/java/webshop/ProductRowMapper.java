package webshop;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("id");
        String name = rs.getString("product_name");
        int price = rs.getInt("price");
        int stock = rs.getInt("stock");
        return new Product(id, name, price, stock);
    }
}
