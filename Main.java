public class Main {
    public static void main(String[] args) {
        CustomerValidator customerValidator = new CustomerValidator();
        OrderProcessor orderProcessor = new OrderProcessor();
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        try {
            // Müşteri bilgilerini doğrulama
            customerValidator.validateName("John Doe");
            customerValidator.validateEmail("john.doe@example.com");

            // Sipariş işleme
            orderProcessor.processOrder(5);

            // Ödeme işleme
            paymentProcessor.processPayment(100.0);
        } catch (InvalidNameException | InvalidEmailException | InvalidOrderQuantityException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}
