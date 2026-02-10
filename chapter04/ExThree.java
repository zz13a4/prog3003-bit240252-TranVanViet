import java.util.function.Predicate;
public class ExThree {
    public static void main(String[] args) {
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("Kiểm tra số chẵn:");
        System.out.println("4 là số chẵn: " + isEven.test(4));
        System.out.println("7 là số chẵn: " + isEven.test(7));
        System.out.println("0 là số chẵn: " + isEven.test(0));
        System.out.println("-2 là số chẵn: " + isEven.test(-2));
        System.out.println("15 là số chẵn: " + isEven.test(15));
    }
}