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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(long consumerId, long restaurantId, List<OrderLineItem> orderLineItems) {
         Restaurant restaurant = restaurantRepository.findById(restaurantId)
                 .orElseThrow(() -> new RestaurantNotFoundException(restaurantId));

        List<OrderItem> availableItems = getAvailableItems(orderLineItems, restaurant);
        Order order = new Order(consumerId, restaurantId, availableItems);
        orderRepository.save(order);
        return order;
    }

    private List<OrderItem> getAvailableItems(List<OrderLineItem> orderLineItems, Restaurant restaurant) {
        return orderLineItems.stream().map(orderLineItem -> {
            MenuItem menuItem = restaurant.findMenuItem(orderLineItem.getMenuItemId()).orElseThrow(() -> new InvalidMenuItemException(orderLineItem.getMenuItemId()));
            return new OrderItem(orderLineItem.getMenuItemId(), menuItem.getName(), menuItem.getPrice(), orderLineItem.getQuantity());
        }).collect(Collectors.toList());
    }
}
