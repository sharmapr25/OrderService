package food.service.order.demo.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class MenuItem {
    private String id;
    private String name;
    private int price;

    public boolean isSameId(String menuItemId) {
        return id.equals(menuItemId);
    }
}
