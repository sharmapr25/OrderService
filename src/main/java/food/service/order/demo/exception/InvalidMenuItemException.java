package food.service.order.demo.exception;

public class InvalidMenuItemException extends RuntimeException {
    public InvalidMenuItemException(String menuItemId) {
        super("Invalid menu item id " + menuItemId);
    }
}
