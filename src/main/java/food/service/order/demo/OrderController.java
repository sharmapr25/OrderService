package food.service.order.demo;

import food.service.order.demo.entity.OrderState;
import food.service.order.demo.web_api_contract.CreateOrderRequest;
import food.service.order.demo.web_api_contract.CreateOrderResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @PostMapping
    public CreateOrderResponse create(@RequestBody CreateOrderRequest request){
        return new CreateOrderResponse(1L, OrderState.APPROVAL_PENDING);
    }
}
