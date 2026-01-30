import java.util.TreeSet;
public class bai7 {
    public static void main(String[] args) {
        // 1
        TreeSet<String> nameSet = new TreeSet<>();
        nameSet.add("John");
        nameSet.add("Alice");
        nameSet.add("Zack");
        nameSet.add("Bob");
        // 2
        System.out.println("Danh sách tên trong TreeSet (tự động sắp xếp):");
        System.out.println(nameSet);
        // 3
        if (!nameSet.isEmpty()) {
            String firstElement = nameSet.first();
            String lastElement = nameSet.last();
            System.out.println("\nPhần tử đầu tiên (nhỏ nhất theo thứ tự): " + firstElement);
            System.out.println("Phần tử cuối cùng (lớn nhất theo thứ tự): " + lastElement);
        } else {
            System.out.println("TreeSet rỗng!");
        }
    }
}