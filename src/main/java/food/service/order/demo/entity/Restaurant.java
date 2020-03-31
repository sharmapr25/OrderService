package food.service.order.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "order_service_restaurants")
@Getter @AllArgsConstructor @NoArgsConstructor
@Access(AccessType.FIELD)
public class Restaurant {

    @Id
    private Long id;

    private String name;

    @Embedded
    @ElementCollection
    @CollectionTable(name = "order_service_restaurant_menu_items")
    private List<MenuItem> menuItems;

    public Optional<MenuItem> findMenuItem(String menuItemId) {
        return this.menuItems.stream().filter(menuItem -> menuItem.isSameId(menuItemId)).findFirst();
    }
}
