import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class ExTwo {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Hanoi", "Ho Chi Minh", "Da Nang", "Hue");
        Collections.sort(cities, (city1, city2) -> city1.length() - city2.length());
        for (String city : cities) {
            System.out.println(city);
        }
    }
}