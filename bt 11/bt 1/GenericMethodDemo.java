public class GenericMethodDemo {
    
    // Phương thức generic printArray
    public static <E> void printArray(E[] array) {
        System.out.println("Các phần tử trong mảng:");
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println("\n------------------------");
    }
    
    // Hàm main để kiểm thử
    public static void main(String[] args) {
        // Tạo mảng Integer
        Integer[] intArray = {10, 20, 30, 40, 50};
        
        // Tạo mảng String
        String[] strArray = {"Java", "Python", "C++", "JavaScript"};
        
        System.out.println("=== Kiểm thử phương thức Generic ===");
        
        // Gọi phương thức với mảng Integer
        System.out.println("Mảng Integer:");
        printArray(intArray);
        
        // Gọi phương thức với mảng String
        System.out.println("Mảng String:");
        printArray(strArray);
    }
}