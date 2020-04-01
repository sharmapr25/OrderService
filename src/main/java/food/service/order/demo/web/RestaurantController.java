package food.service.order.demo.web;

import food.service.order.demo.entity.Restaurant;
import food.service.order.demo.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping
    public Long create(@RequestBody Restaurant restaurant){
        return restaurantService.create(restaurant);
    }
}
