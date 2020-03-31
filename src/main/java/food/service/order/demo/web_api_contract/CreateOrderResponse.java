package food.service.order.demo.web_api_contract;

import food.service.order.demo.entity.OrderState;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class CreateOrderResponse {
    private long orderId;
    private OrderState orderState;

    public boolean isSameOrderState(OrderState orderState) {
        return this.orderState.equals(orderState);
    }
}
