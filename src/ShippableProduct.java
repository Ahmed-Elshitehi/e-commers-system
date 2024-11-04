import java.time.LocalDate;

public class ShippableProduct extends Product implements Shippable{
    private double weight;

    public ShippableProduct(String name, double price, int quantity, LocalDate productExpireDate, double weight) {
        super(name, price, quantity, productExpireDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public String getName() {
        return super.getName();
    }
}
