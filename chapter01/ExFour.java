import java.util.ArrayList;
public class ExFour {
    public static void main(String[] args) {
        //1
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        System.out.println("Danh sách ban đầu: " + fruits);
        //2
        fruits.add(1, "Mango");
        System.out.println("Sau khi thêm Mango vào vị trí index 1: " + fruits);
        //3
        int bananaIndex = fruits.indexOf("Banana");
        if (bananaIndex != -1) {
            fruits.set(bananaIndex, "Grapes");
            System.out.println("Sau khi thay Banana bằng Grapes: " + fruits);
        } else {
            System.out.println("Không tìm thấy Banana trong danh sách");
        }
        // 4
        boolean hasApple = fruits.contains("Apple");
        System.out.println("Có Apple trong danh sách? " + hasApple);
    }
}