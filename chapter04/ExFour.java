import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
public class ExFour {
    public static void main(String[] args) {
        List<String> currencies = Arrays.asList("$10", "$20", "$50", "$100", "$500");
        Function<String, Integer> currencyConverter = str -> {
            String numberStr = str.substring(1);
            return Integer.parseInt(numberStr);
        };
        System.out.println("Danh sách tiền tệ gốc:");
        for (String currency : currencies) {
            System.out.print(currency + " ");
        }
        System.out.println("\n\nDanh sách sau khi chuyển đổi:");
        for (String currency : currencies) {
            Integer result = currencyConverter.apply(currency);
            System.out.print(result + " ");
        }
    }
}