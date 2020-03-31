package food.service.order.demo.exception;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(long restaurantId) {
        super("Restaurant not found with id " + restaurantId);
    }
}
