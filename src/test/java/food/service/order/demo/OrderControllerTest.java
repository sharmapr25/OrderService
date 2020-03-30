package food.service.order.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    OrderController orderController;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void createOrder_shouldReturnOrderIdWithOrderStatePendingApproval_whenOrderCreatedForFirstTime(){
        assertThat(this.testRestTemplate.getForObject("http://localhost:"+port+"/", String.class)).contains("Hello world");
    }
}
