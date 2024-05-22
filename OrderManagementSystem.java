import java.util.Scanner;

class InvalidOrderException extends Exception {
    public InvalidOrderException(String message) {
        super(message);
    }
}

class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}

class Customer {
    String name;
    String address;
    String phone;

    Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}

class Order {
    String product;
    int quantity;

    Order(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

public class OrderManagementSystem {

    public static Customer getCustomerDetails() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Müşteri İsmi: ");
        String name = scanner.nextLine();

        System.out.print("Müşteri Adresi: ");
        String address = scanner.nextLine();

        System.out.print("Müşteri Telefonu: ");
        String phone = scanner.nextLine();

        if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
            throw new Exception("Müşteri bilgileri eksik.");
        }

        return new Customer(name, address, phone);
    }

    public static boolean validateOrder(Order order) throws InvalidOrderException {
        if (order.product == null || order.product.isEmpty() || order.quantity <= 0) {
            throw new InvalidOrderException("Geçersiz ürün veya miktar.");
        }
        return true;
    }

    public static boolean processPayment(double amount) throws PaymentFailedException {
        if (amount <= 0) {
            throw new PaymentFailedException("Geçersiz ödeme miktarı.");
        }

        // Ödeme işlemi (örnek: her zaman başarılı)
        System.out.println(amount + " TL ödeme başarıyla gerçekleşti.");
        return true;
    }

    public static void main(String[] args) {
        try {
            Customer customer = getCustomerDetails();
            Order order = new Order("Laptop", 1);  // Örnek sipariş

            if (validateOrder(order)) {
                double amount = 1500.0;  // Örnek ödeme miktarı
                processPayment(amount);
            }

        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}