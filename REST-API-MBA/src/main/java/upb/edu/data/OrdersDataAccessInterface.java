package upb.edu.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import upb.edu.restapimba.Models.OrderModel;

@Repository
public interface OrdersDataAccessInterface {
    
    public OrderModel getByid(long id);

    public List<OrderModel> getOrders();

    public List<OrderModel> searchOrders(String searchTerm);

    public long addOne(OrderModel newOrder);

    public boolean deleteOne(long id);

    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder);
}
