package upb.edu.restapimba.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import upb.edu.data.OrdersDataAccessInterface;
import upb.edu.restapimba.Models.OrderModel;

public class OrderBusinessService implements OrdersBusinessServiceInterface {

    @Autowired
    OrdersDataAccessInterface ordersDAO;

    @Override
    public void test() {
        System.out.println("OrderBusiness is working");
    }

    @Override
    public List<OrderModel> getOrders() {
        return ordersDAO.getOrders();
    }

    @Override
    public void init(){
        System.out.println("Init method");
    }

    @Override
    public void destroy(){
        System.out.println("Destroy method");
    }

    @Override
    public OrderModel getByid(long id) {
        return ordersDAO.getByid(id);
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        return ordersDAO.searchOrders(searchTerm);
    }

    @Override
    public long addOne(OrderModel newOrder) {
        return ordersDAO.addOne(newOrder);
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
