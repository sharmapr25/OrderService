package food.service.order.demo.services;

import food.service.order.demo.entity.MenuItem;
import food.service.order.demo.entity.Order;
import food.service.order.demo.entity.OrderItem;
import food.service.order.demo.entity.Restaurant;
import food.service.order.demo.exception.InvalidMenuItemException;
import food.service.order.demo.exception.RestaurantNotFoundException;
import food.service.order.demo.repository.OrderRepository;
import food.service.order.demo.repository.RestaurantRepository;
import food.service.order.demo.web_api_contract.OrderLineItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @Mock
    OrderRepository orderRepository;

    @Mock
    RestaurantRepository restaurantRepository;

    @InjectMocks
    OrderService orderService;

    @Test
    public void createOrder_shouldThrowRestaurantNotFoundException_whenGivenRestaurantDoesNotExist(){
        when(restaurantRepository.findById(1L)).thenThrow(new RestaurantNotFoundException(1L));

        assertThrows(RestaurantNotFoundException.class, ()->{
            orderService.createOrder(1L, 1L, Collections.EMPTY_LIST);
        });
    }

    @Test
    public void createOrder_shouldThrowInvalidMenuItemException_whenGivenOrderLineItemDoesNotExistInGivenRestaurant(){
        OrderLineItem orderLineItem = new OrderLineItem("Dessert-02", 2);

        MenuItem menuItem = new MenuItem("Dessert-01", "Jalebi", 30);
        Restaurant restaurant = new Restaurant(1L, "Dhaba", Collections.singletonList(menuItem));

        when(restaurantRepository.findById(1L)).thenReturn(Optional.of(restaurant));


        assertThrows(InvalidMenuItemException.class, ()->{
            orderService.createOrder(1L, 1L, Collections.singletonList(orderLineItem));
        });
    }

    @Test
    public void createOrder_shouldReturnAnOrderWithStatusPending_whenGivenMenuItemsExistForGivenRestaurant(){
        OrderLineItem orderLineItem = new OrderLineItem("Dessert-01", 2);

        MenuItem menuItem = new MenuItem("Dessert-01", "Jalebi", 30);
        Restaurant restaurant = new Restaurant(1L, "Dhaba", Collections.singletonList(menuItem));

        when(restaurantRepository.findById(1L)).thenReturn(Optional.of(restaurant));
        when(orderRepository.save(any(Order.class))).thenReturn(null);

        Order order = orderService.createOrder(1L, 1L, Collections.singletonList(orderLineItem));

        OrderItem jalebi = new OrderItem("Dessert-01", "Jalebi", 30, 2);
        Order expectedOrder = new Order(1L, 1L, Collections.singletonList(jalebi));

        assertEquals(expectedOrder, order);
    }
}
