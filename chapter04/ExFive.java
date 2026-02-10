import java.util.function.Supplier;
import java.util.function.Consumer;
public class ExFive {
    public static void main(String[] args) {
        Supplier<Double> randomSupplier = () -> Math.random() * 100;
        Consumer<Double> printConsumer = number -> 
            System.out.printf("Số may mắn: %.2f\n", number);
        System.out.println("Các số may mắn:");
        for (int i = 1; i <= 5; i++) {
            Double luckyNumber = randomSupplier.get();
            printConsumer.accept(luckyNumber);
        }
    }
}