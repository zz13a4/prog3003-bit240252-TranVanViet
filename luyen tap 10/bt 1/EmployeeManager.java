package HashMap;
import java.util.HashMap;
import java.util.Map;
public class EmployeeManager {
    public static void main(String[] args) {
        // 1. Tạo HashMap
        Map<Integer, String> employees = new HashMap<>();
        
        // 2. Thêm 3 nhân viên
        employees.put(101, "Anna");
        employees.put(102, "Peter");
        employees.put(103, "Mary");
        
        System.out.println("=== DANH SÁCH NHÂN VIÊN ===");
        System.out.println(employees);
        System.out.println();
        
        // 3. Lấy tên nhân viên có ID 102
        String employee102 = employees.get(102);
        System.out.println("Nhân viên có ID 102: " + employee102);
        System.out.println();
        
        // 4. Kiểm tra ID 105
        if (!employees.containsKey(105)) {
            employees.put(105, "Unknown");
            System.out.println("Đã thêm ID 105 với tên Unknown");
        } else {
            System.out.println("ID 105 đã tồn tại");
        }
        
        // Hiển thị kết quả cuối cùng
        System.out.println("\n=== DANH SÁCH SAU KHI THÊM ===");
        System.out.println(employees);
    }
}