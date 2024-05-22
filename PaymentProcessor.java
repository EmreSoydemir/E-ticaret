import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PaymentProcessor {
    public void processPayment(double amount) {
        BufferedWriter writer = null;
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Ödeme miktarı geçersiz: Miktar pozitif olmalıdır.");
            }
            // Ödeme işleme kodları burada yer alacak
            writer = new BufferedWriter(new FileWriter("payment_log.txt", true));
            writer.write("Ödeme başarılı: Miktar - " + amount);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Hata: Dosya yazma hatası!");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Hata: Dosya kapatma hatası!");
            }
        }
    }
}
