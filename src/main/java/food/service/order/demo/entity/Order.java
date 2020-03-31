package food.service.order.demo.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
@Setter @Getter @NoArgsConstructor
@EqualsAndHashCode @ToString
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    private Long consumerId;
    private Long restaurantId;

    @ElementCollection
    @CollectionTable(name = "order_items")
    private List<OrderItem> orderItems;


    public Order(long consumerId, long restaurantId, List<OrderItem> orderItems) {
        this.consumerId = consumerId;
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
        this.orderState = OrderState.APPROVAL_PENDING;
    }
}
