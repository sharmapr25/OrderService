package food.service.order.demo.web;

import food.service.order.demo.entity.Order;
import food.service.order.demo.services.OrderService;
import food.service.order.demo.web_api_contract.CreateOrderRequest;
import food.service.order.demo.web_api_contract.CreateOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public CreateOrderResponse create(@RequestBody CreateOrderRequest request){
        Order order = orderService.createOrder(request.getConsumerId(), request.getRestaurantId(),request.getOrderLineItems());
        return new CreateOrderResponse(order.getId(), order.getOrderState());
    }
}
