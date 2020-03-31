package food.service.order.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.service.order.demo.entity.OrderState;
import food.service.order.demo.web.OrderController;
import food.service.order.demo.web_api_contract.CreateOrderRequest;
import food.service.order.demo.web_api_contract.OrderLineItem;
import food.service.order.demo.web_api_contract.CreateOrderResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

    @LocalServerPort
    private int randomServerPort;

    @Autowired
    OrderController orderController;

    @Autowired
    TestRestTemplate restTemplate;

    ObjectMapper objectMapper;

    @Before
    public void setup(){
        objectMapper = new ObjectMapper();
    }

    @Test
    public void createOrder_shouldReturnOrderIdWithOrderStatePendingApproval_whenOrderCreatedForFirstTime() throws JsonProcessingException {
        String baseUrl = "http://localhost:" + randomServerPort + "/orders";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        OrderLineItem orderLineItem = new OrderLineItem("desert-01", 1);
        CreateOrderRequest firstOrder = new CreateOrderRequest(1L, 90L, Collections.singletonList(orderLineItem));
        String firstOrderAsString = objectMapper.writeValueAsString(firstOrder);

        HttpEntity<String> request = new HttpEntity<>(firstOrderAsString, httpHeaders);
        String response = this.restTemplate.postForObject(baseUrl, request, String.class);
        CreateOrderResponse orderResponse = objectMapper.readValue(response, CreateOrderResponse.class);

        assertTrue(orderResponse.isSameOrderState(OrderState.APPROVAL_PENDING));

    }
}
