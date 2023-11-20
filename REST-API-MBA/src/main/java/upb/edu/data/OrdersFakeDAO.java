package upb.edu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import upb.edu.restapimba.Models.OrderModel;

@Repository
public class OrdersFakeDAO implements OrdersDataAccessInterface{

    ArrayList<OrderModel> orders = new ArrayList<OrderModel>();

    public OrdersFakeDAO() {
        orders.add(new OrderModel(0L, "000", "Sky diving", 1500.0f, 1));
        orders.add(new OrderModel(1L, "001", "coke", 1500.0f, 1));
        orders.add(new OrderModel(2L, "002", "The example", 1500.0f, 1));
        orders.add(new OrderModel(3L, "003", "The sky diving", 1500.0f, 1));
        orders.add(new OrderModel(4L, "004", "The product name", 1500.0f, 1));
    }

    @Override
    public OrderModel getByid(long id) {
        for(int i=0; i < orders.size(); i++){
            if(orders.get(i).getId() == id){
                return orders.get(i);
            }
        }
        return null;
    }

    @Override
    public List<OrderModel> getOrders() {
        return orders;
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        // given a search term, create a list of items whose description matches

        List<OrderModel> foundItems = new ArrayList<OrderModel>();
        for(int i=0 ; i < orders.size(); i++){
            if(orders.get(i).getProductName().toLowerCase().contains(searchTerm.toLowerCase())){
                foundItems.add(orders.get(i));
            }
        }
        return foundItems;
    }

    @Override
    public long addOne(OrderModel newOrder) {
        boolean success = orders.add(newOrder);
        if(success){
            return 1;
        }else{
            return 0;
        }

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
