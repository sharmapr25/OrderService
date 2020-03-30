package food.service.order.demo.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class OrderItem {
    private int quantity;
    private String menuItemId;
    private String name;
    private int price;
}
