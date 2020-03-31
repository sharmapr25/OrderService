package food.service.order.demo.web_api_contract;

import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class CreateOrderRequest {
    private long consumerId;
    private long restaurantId;
    private List<OrderLineItem> orderLineItems;
}
