package upb.edu.restapimba.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import upb.edu.restapimba.Models.OrderModel;
import upb.edu.restapimba.Services.OrdersBusinessServiceInterface;


@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    
    @Autowired
    OrdersBusinessServiceInterface service;
    
    public OrderController(OrdersBusinessServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/getall")
    public List<OrderModel> showAllOrders() { 
        List<OrderModel> orders = service.getOrders();
        return orders;
    }

    @GetMapping("/search/{searchTerm}")
    public List<OrderModel> searchOrders(@PathVariable(name="searchTerm") String searchTerm){
        List<OrderModel> orders = service.searchOrders(searchTerm);
        return orders;
    }

    @PostMapping("/add/")
    public long addOrder(@RequestBody OrderModel model){
        return service.addOne(model);
    }

    @GetMapping("/getOrder/{id}")
    public OrderModel getById(@PathVariable(name="id") long id){
        return service.getByid(id);
    }
}