import java.time.LocalDate;

public class Product implements Shippable{
    private String name;
    private double price;
    private int quantity;
    private double weight;
    private LocalDate productExpireDate;

    public Product(String name, double price, int quantity, LocalDate productExpireDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.productExpireDate = productExpireDate;
    }
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getProductExpireDate() {
        return productExpireDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
