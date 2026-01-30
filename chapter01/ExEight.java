import java.util.HashMap;
public class bai8 {
    public static void main(String[] args) {
        // 1
        HashMap<Integer, String> employees = new HashMap<>();
        // 2
        employees.put(101, "Anna");
        employees.put(102, "Peter");
        employees.put(103, "Mary");
        System.out.println("Danh sách nhân viên ban đầu:");
        System.out.println(employees);
        // 3
        String employeeName = employees.get(102);
        System.out.println("\nTên nhân viên có ID 102: " + employeeName);
        // 4
        if (!employees.containsKey(105)) {
            employees.put(105, "Unknown");
            System.out.println("ID 105 không tồn tại, đã thêm mới với tên 'Unknown'");
        } else {
            System.out.println("ID 105 đã tồn tại");
        }
        System.out.println("\nDanh sách nhân viên sau khi kiểm tra:");
        System.out.println(employees);
    }
}