package food.service.order.demo.services;

import food.service.order.demo.entity.Restaurant;
import food.service.order.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public Long create(Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return savedRestaurant.getId();
    }
}
