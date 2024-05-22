class InvalidOrderQuantityException extends Exception {
    public InvalidOrderQuantityException(String message) {
        super(message);
    }
}

public class OrderProcessor {
    public void processOrder(int quantity) throws InvalidOrderQuantityException {
        if (quantity <= 0) {
            throw new InvalidOrderQuantityException("Sipariş miktarı geçersiz: Miktar pozitif olmalıdır.");
        }
        // Sipariş işleme kodları burada yer alacak
        System.out.println("Sipariş işlendi: Miktar - " + quantity);
    }
}