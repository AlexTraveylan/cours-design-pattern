public interface PaymentMethod {
    void processPayment(double amount);
}

public class PayPalPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        // Logic for processing payment via PayPal
    }
}

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        // Logic for processing payment via Credit Card
    }
}

public class PaymentFactory {
    public static PaymentMethod getPaymentMethod(String type) {
        switch (type) {
            case "PayPal":
                return new PayPalPayment();
            case "CreditCard":
                return new CreditCardPayment();
            default:
                throw new IllegalArgumentException("Unknown payment method");
        }
    }
}