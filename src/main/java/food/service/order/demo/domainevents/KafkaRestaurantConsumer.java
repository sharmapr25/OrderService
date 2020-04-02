package food.service.order.demo.domainevents;

import food.service.order.demo.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaRestaurantConsumer {

    @Autowired
    RestaurantService restaurantService;

    @KafkaListener(topics="${spring.kafka.template.default-topic}")
    public void processMessage(String restaurantStr){
        restaurantService.create(restaurantStr);
    }
}
