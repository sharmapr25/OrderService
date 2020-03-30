package food.service.order.demo.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
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

}
