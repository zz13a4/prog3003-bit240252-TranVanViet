import java.util.TreeSet;
public class tree {
    public static void main(String[] args) {
        // 1. Tạo TreeSet và thêm tên
        TreeSet<String> names = new TreeSet<>();
        names.add("John");
        names.add("Alice");
        names.add("Zack");
        names.add("Bob");

        // 2. In danh sách
        System.out.println("Danh sách tên (đã sắp xếp): " + names);

        // 3. Lấy phần tử đầu và cuối
        String first = names.first();
        String last = names.last();

        System.out.println("Phần tử đầu tiên (nhỏ nhất): " + first);
        System.out.println("Phần tử cuối cùng (lớn nhất): " + last);
    }
}