package food.service.order.demo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.service.order.demo.entity.Restaurant;
import food.service.order.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public void create(String restaurantStr){
        try {
            Restaurant restaurant = new ObjectMapper().readValue(restaurantStr, Restaurant.class);
            restaurantRepository.save(restaurant);
        } catch (JsonProcessingException exception) {
            exception.printStackTrace();
        }
    }
}
