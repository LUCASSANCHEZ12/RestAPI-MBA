package upb.edu.restapimba.Services;

import java.util.List;

import upb.edu.restapimba.Models.OrderModel;

public interface OrdersBusinessServiceInterface {
    public void test();
    
    public OrderModel getByid(long id);

    public List<OrderModel> getOrders();

    public List<OrderModel> searchOrders(String searchTerm);

    public long addOne(OrderModel newOrder);

    public boolean deleteOne(long id);

    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder);

    public void destroy();
    
    public void init();

}
