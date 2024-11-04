public class Checkout {
    public void checkout(Customer customer, Cart cart) throws Exception {
        if (cart.getItems().isEmpty()) {
            throw new Exception("Cart is empty.");
        }

        double subtotal = calculateSubtotal(cart);
        double shippingFee = calculateShippingFee(cart);
        double totalWeight = calculateTotalWeight(cart);

        printShipmentNotice(cart, totalWeight);
        printCheckoutReceipt(cart);

        double totalAmount = subtotal + shippingFee;
        customer.pay(totalAmount);

        printFinalSummary(subtotal, shippingFee, totalAmount, customer);
    }

    private double calculateSubtotal(Cart cart) {
        double subtotal = 0;
        for (CartItem item : cart.getItems()) {
            subtotal += item.getQuantity() * item.getProduct().getPrice();
        }
        return subtotal;
    }

    private double calculateShippingFee(Cart cart) {
        double shippingFee = 0;
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().getWeight() > 0.0) {
                shippingFee += item.getQuantity() * (item.getProduct().getWeight());
            }
        }
        return shippingFee;
    }

    private double calculateTotalWeight(Cart cart) {
        double totalWeight = 0;
        for (CartItem item : cart.getItems()) {
            totalWeight += item.getQuantity() * item.getProduct().getWeight();
        }
        return totalWeight;
    }

    private void printShipmentNotice(Cart cart, double totalWeight) {
        System.out.println("** Shipment notice **");
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product.getWeight() > 0.0) {
                System.out.println(item.getQuantity() + "x " + product.getName() + "        " + (product.getWeight() * item.getQuantity()) / 1000 + "g");
            }
        }
        System.out.printf("Total package weight: %.2f kg%n%n", totalWeight / 1000);
    }

    private void printCheckoutReceipt(Cart cart) {
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "        " + item.getProduct().getPrice() * item.getQuantity());
        }
    }

    private void printFinalSummary(double subtotal, double shippingFee, double totalAmount, Customer customer) {
        System.out.println("------------------------");
        System.out.println("Subtotal:   " + subtotal);
        System.out.println("Shipping:   " + shippingFee);
        System.out.println("Amount Paid: " + totalAmount);
        System.out.println("Remaining Balance: " + customer.getBalance());
    }
}
