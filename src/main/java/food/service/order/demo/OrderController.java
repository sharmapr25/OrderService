package food.service.order.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping("/")
    public String greeting(){
        return "Hello world";
    }
}
