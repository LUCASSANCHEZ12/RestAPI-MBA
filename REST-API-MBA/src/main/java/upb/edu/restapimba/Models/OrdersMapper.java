package upb.edu.restapimba.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class OrdersMapper implements RowMapper<OrderModel>
{

    @Override
    @Nullable
    public OrderModel mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
        OrderModel order = new OrderModel(rs.getLong("ID"), rs.getString("ORDER_NUMBER"), rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE"), rs.getInt("QTY"));
        return order;
    }

}