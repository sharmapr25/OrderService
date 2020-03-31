package food.service.order.demo.entity;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuItemTest {
    @Test
    public void isSameId_shouldReturnTrue_whenGivenIdIsSameAsMenuItemId(){
        MenuItem menuItem = new MenuItem("Dessert", "Jalebi", 30);
        assertTrue(menuItem.isSameId("Dessert"));
    }

    @Test
    public void isSameId_shouldReturnFalse_whenGivenIdIsNotSameAsMenuItemId(){
        MenuItem menuItem = new MenuItem("Dessert", "Jalebi", 30);
        assertFalse(menuItem.isSameId("Meal"));
    }
}
