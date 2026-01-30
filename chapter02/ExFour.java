import java.util.ArrayList;
import java.util.List;

interface PaymentStrategy {
    void pay(int amount);
    String getPaymentMethod();
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;
    
    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = maskCardNumber(cardNumber);
        this.cardHolder = cardHolder;
    }
    
    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() > 4) {
            return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        }
        return cardNumber;
    }
    @Override
    public void pay(int amount) {
        System.out.println(" Processing credit card payment of $" + amount);
        System.out.println(" Card: " + cardNumber);
        System.out.println(" Payment successful!");
    } 
    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    
    public PayPalPayment(String email) {
        this.email = email;
    }
    @Override
    public void pay(int amount) {
        System.out.println(" Processing PayPal payment of $" + amount);
        System.out.println(" Email: " + email);
        System.out.println(" Payment successful!");
    }
    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}

class ShoppingCart {
    private List<String> items;
    private int total;
    private PaymentStrategy paymentStrategy;
    public ShoppingCart() {
        items = new ArrayList<>();
        total = 0;
    }
    public void addItem(String item, int price) {
        items.add(item);
        total += price;
    }
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
        System.out.println("Payment method set to: " + strategy.getPaymentMethod());
    }
    public void checkout() {
        if (paymentStrategy == null) {
            System.out.println(" Please select a payment method first!");
            return;
        }
        System.out.println("\n=== CHECKOUT ===");
        System.out.println("Items: " + items);
        System.out.println("Total: $" + total);
        paymentStrategy.pay(total);
        System.out.println("Thank you for your purchase!\n");
        items.clear();
        total = 0;
    }
    public void showSummary() {
        System.out.println("\n Cart Summary:");
        System.out.println("Items: " + items);
        System.out.println("Total: $" + total);
        if (paymentStrategy != null) {
            System.out.println("Selected payment: " + paymentStrategy.getPaymentMethod());
        }
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        System.out.println("=== STRATEGY PATTERN: PAYMENT SYSTEM ===\n");
        ShoppingCart cart = new ShoppingCart();
        
        cart.addItem("iPhone 15", 999);
        cart.addItem("AirPods Pro", 249);
        cart.showSummary();
        
        System.out.println("\n--- Test 1: Credit Card Payment ---");
        PaymentStrategy creditCard = new CreditCardPayment("4111111111111111", "John Doe");
        cart.setPaymentStrategy(creditCard);
        cart.checkout();
        
        System.out.println("--- Test 2: Change to PayPal at Runtime ---");
        cart.addItem("MacBook Air", 1299);
        cart.addItem("USB-C Cable", 29);
        cart.showSummary();
        
        PaymentStrategy paypal = new PayPalPayment("john.doe@email.com");
        cart.setPaymentStrategy(paypal);
        cart.checkout();
        System.out.println("--- Test 3: Dynamic Strategy Switching ---");
        cart.addItem("iPad Pro", 1099);
        cart.showSummary();
        
        cart.setPaymentStrategy(creditCard);
        System.out.println("Changed mind, switching to PayPal...");
        cart.setPaymentStrategy(paypal);
        cart.checkout();
    }
}