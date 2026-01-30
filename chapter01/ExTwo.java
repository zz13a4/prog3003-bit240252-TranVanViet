public class ExTwo {
    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println(); 
    }
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.print("Mảng Integer: ");
        printArray(intArray);
        String[] stringArray = {"Hello", "World", "Java", "Generics"};
        System.out.print("Mảng String: ");
        printArray(stringArray);
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        System.out.print("Mảng Double: ");
        printArray(doubleArray);
        Character[] charArray = {'A', 'B', 'C', 'D', 'E'};
        System.out.print("Mảng Character: ");
        printArray(charArray);
    }
}