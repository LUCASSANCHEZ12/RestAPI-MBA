package upb.edu.restapimba;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import upb.edu.restapimba.Services.OrderBusinessService;
import upb.edu.restapimba.Services.OrdersBusinessServiceInterface;

@Configuration
public class SpringConfig {
    @Bean(name="orderBusinessService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public OrdersBusinessServiceInterface getOrdersBusiness(){
        return new OrderBusinessService();
    }
}
