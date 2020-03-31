package food.service.order.demo.entity;

import org.junit.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RestaurantTest {

    @Test
    public void findMenuItem_shouldReturnItem_whenTheRestaurantHasGivenItem(){
        MenuItem menuItem = new MenuItem("Dessert-01", "Jalebi", 30);
        Restaurant restaurant = new Restaurant(1L, "Dhaba", Collections.singletonList(menuItem));

        MenuItem foundMenuItem = restaurant.findMenuItem("Dessert-01").get();

        assertEquals(menuItem, foundMenuItem);
    }

    @Test
    public void findMenuItem_shouldReturnNull_whenTheRestaurantDoesNotHasTheGivenItem(){
        MenuItem menuItem = new MenuItem("Dessert-01", "Jalebi", 30);
        Restaurant restaurant = new Restaurant(1L, "Dhaba", Collections.singletonList(menuItem));

        boolean isItemFound = restaurant.findMenuItem("Dessert-02").isPresent();

        assertFalse(isItemFound);
    }
}
