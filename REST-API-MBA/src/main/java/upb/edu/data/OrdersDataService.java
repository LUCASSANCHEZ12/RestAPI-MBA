package upb.edu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import upb.edu.restapimba.Models.OrderModel;
import upb.edu.restapimba.Models.OrdersMapper;

@Repository
public class OrdersDataService implements OrdersDataAccessInterface
{

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public OrderModel getByid(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByid'");
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderModel> results = jdbcTemplate.query("SELECT * FROM ORDERS", new OrdersMapper());
        return results;
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchOrders'");
    }

    @Override
    public long addOne(OrderModel newOrder) {
        long result = jdbcTemplate.update("INSERT INTO ORDERS (ORDER_NUMBER, PRODUCT_NAME, PRICE, QTY) VALUES (?,?,?,?)", newOrder.getOrderNo(), newOrder.getProductName(), newOrder.getPrice(), newOrder.getQuantity());
        return result;
    }

    @Override   
    public boolean deleteOne(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOne'");
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOne'");
    }

}
