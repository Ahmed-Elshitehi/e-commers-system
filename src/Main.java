import javax.lang.model.type.NullType;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 20, 10, LocalDate.now().plusDays(50), 250);
        Product tv = new Product("TV", 1500, 5, null, 5000);
        Customer customer = new Customer("Ahmed", 5000);
        try {
            Cart cart = new Cart();
            cart.add(cheese, 2);
            cart.add(tv, 1);

            Checkout checkoutService = new Checkout();
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}