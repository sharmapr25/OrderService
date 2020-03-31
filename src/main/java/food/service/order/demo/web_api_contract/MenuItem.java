package food.service.order.demo.web_api_contract;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class MenuItem {
    private String menuItemId;
    private int quantity;
}
