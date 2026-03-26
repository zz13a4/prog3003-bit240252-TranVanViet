
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.stream.Stream;

public class EmployeeStreamDemo {
    
    public static void main(String[] args) {
        

        System.out.println("DEMO STREAM API & COLLECTORS");
        
        // ========== PHẦN 1: Tạo danh sách nhân viên ==========
        System.out.println("🔷 PHẦN 1: DANH SÁCH NHÂN VIÊN BAN ĐẦU 🔷");
        System.out.println("----------------------------------------");
        
        List<Employee> employees = createEmployeeList();
        displayEmployees(employees);
        
        // ========== PHẦN 2: Yêu cầu 1, 2, 3 - Lọc, Sắp xếp, Gom ==========
        System.out.println("\n\n🔷 PHẦN 2: XỬ LÝ VỚI STREAM 🔷");
        System.out.println("Yêu cầu: Lấy danh sách tên nhân viên có lương > 1000");
        System.out.println("         Sắp xếp theo thứ tự Alphabet");
        System.out.println("         Gom kết quả về List");
        System.out.println("----------------------------------------");
        List<String> highSalaryNames1 = employees.stream()
            .filter(employee -> employee.getSalary() > 1000)
            .map(employee -> employee.getName())
            .sorted()
            .collect(Collectors.toList());
        List<String> highSalaryNames2 = employees.stream()
            .filter(emp -> emp.getSalary() > 1000)
            .map(Employee::getName)
            .sorted()
            .collect(Collectors.toList());
        // In kết quả
        System.out.println("\n📋 KẾT QUẢ (Cách 1):");
        printNameList(highSalaryNames1);
        
        System.out.println("\n📋 KẾT QUẢ (Cách 2 - Method Reference):");
        printNameList(highSalaryNames2);
 
        // ========== PHẦN 3: Hiển thị chi tiết ==========
        System.out.println("\n\n PHẦN 3: CHI TIẾT NHÂN VIÊN CÓ LƯƠNG > 1000 ");
        System.out.println("----------------------------------------");
        
        List<Employee> highSalaryEmployees = employees.stream()
            .filter(emp -> emp.getSalary() > 1000)
            .collect(Collectors.toList());
        
        System.out.println("Số lượng: " + highSalaryEmployees.size() + " nhân viên");
        highSalaryEmployees.forEach(System.out::println);
        
        // ========== PHẦN 4: Các thao tác khác với Stream ==========
        System.out.println("\n\n🔷 PHẦN 4: CÁC THAO TÁC KHÁC VỚI STREAM 🔷");
        System.out.println("----------------------------------------");
        
        // 4.1. Đếm số lượng nhân viên lương > 1000
        long count = employees.stream()
            .filter(emp -> emp.getSalary() > 1000)
            .count();
        System.out.println("1️⃣ Số lượng nhân viên lương > 1000: " + count);
        
        // 4.2. Tính lương trung bình của nhân viên lương > 1000
        double avgSalary = employees.stream()
            .filter(emp -> emp.getSalary() > 1000)
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0);  // Nếu không có kết quả thì trả về 0
        System.out.printf("2️⃣ Lương trung bình (lương > 1000): %.2f\n", avgSalary);
        
        // 4.3. Tìm nhân viên có lương cao nhất
        employees.stream()
            .max(Comparator.comparing(Employee::getSalary))
            .ifPresent(emp -> System.out.println("3️⃣ Nhân viên lương cao nhất: " + emp));
        
        // 4.4. Tìm nhân viên có lương thấp nhất
        employees.stream()
            .min(Comparator.comparing(Employee::getSalary))
            .ifPresent(emp -> System.out.println("4️⃣ Nhân viên lương thấp nhất: " + emp));
        
        // 4.5. Sắp xếp nhân viên theo lương giảm dần
        System.out.println("\n5️⃣ Danh sách nhân viên sắp xếp theo lương giảm dần:");
        employees.stream()
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            .forEach(emp -> System.out.println("   " + emp));
        
        // 4.6. Kiểm tra có nhân viên nào lương > 2000 không?
        boolean hasHighSalary = employees.stream()
            .anyMatch(emp -> emp.getSalary() > 2000);
        System.out.println("\n6️⃣ Có nhân viên nào lương > 2000? " + hasHighSalary);
        
        // 4.7. Tính tổng lương của tất cả nhân viên
        double totalSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .sum();
        System.out.printf("7️⃣ Tổng lương tất cả nhân viên: %.2f\n", totalSalary);
        
        // ========== PHẦN 5: Các cách viết Stream khác ==========
        System.out.println("\n\n🔷 PHẦN 5: CÁC CÁCH VIẾT STREAM KHÁC 🔷");
        System.out.println("----------------------------------------");
        
        // Cách 1: Viết đầy đủ
        System.out.println("Cách 1 (Lambda Expression):");
        List<String> names1 = employees.stream()
            .filter((Employee emp) -> {
                return emp.getSalary() > 1000;
            })
            .map((Employee emp) -> {
                return emp.getName();
            })
            .sorted()
            .collect(Collectors.toList());
        printNameList(names1);
        
        // Cách 2: Viết ngắn gọn
        System.out.println("\nCách 2 (Method Reference):");
        List<String> names2 = employees.stream()
            .filter(emp -> emp.getSalary() > 1000)
            .map(Employee::getName)
            .sorted()
            .collect(Collectors.toList());
        printNameList(names2);
        
        // Cách 3: Dùng Stream pipeline liên tiếp
        System.out.println("\nCách 3 (Inline Stream):");
        employees.stream()
            .filter(emp -> emp.getSalary() > 1000)
            .map(Employee::getName)
            .sorted()
            .forEach(name -> System.out.println("   - " + name));
        
        // ========== PHẦN 6: Sử dụng Collectors nâng cao ==========
        System.out.println("\n\n🔷 PHẦN 6: COLLECTORS NÂNG CAO 🔷");
        System.out.println("----------------------------------------");
        
        // 6.1. Gom thành List (đã làm ở trên)
        List<String> nameList = employees.stream()
            .filter(emp -> emp.getSalary() > 1000)
            .map(Employee::getName)
            .sorted()
            .collect(Collectors.toList());
        
        // 6.2. Gom thành Set (loại bỏ trùng lặp)
        // (Giả sử có tên trùng nhau)
        
        // 6.3. Gom thành Map (id -> name)
        System.out.println("\n📌 Map (id -> name) của nhân viên lương > 1000:");
        employees.stream()
            .filter(emp -> emp.getSalary() > 1000)
            .collect(Collectors.toMap(
                Employee::getId,      // key
                Employee::getName,    // value
                (v1, v2) -> v1        // nếu trùng key thì giữ giá trị đầu
            ))
            .forEach((id, name) -> System.out.println("   ID: " + id + " -> Tên: " + name));
        
        // 6.4. Gom thành String với delimiter
        String namesString = employees.stream()
            .filter(emp -> emp.getSalary() > 1000)
            .map(Employee::getName)
            .sorted()
            .collect(Collectors.joining(", "));
        System.out.println("\n📌 Danh sách tên (dạng String): " + namesString);
        
        // 6.5. Gom thành List và sắp xếp ngược
        List<String> reversedNames = employees.stream()
            .filter(emp -> emp.getSalary() > 1000)
            .map(Employee::getName)
            .sorted(Comparator.reverseOrder())  // Sắp xếp giảm dần
            .collect(Collectors.toList());
        System.out.println("\n📌 Danh sách tên (sắp xếp Z-A):");
        printNameList(reversedNames);
        
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("              KẾT THÚC DEMO");
        System.out.println("═══════════════════════════════════════════════════");
    }
    
    /**
     * Phương thức tạo danh sách nhân viên mẫu
     */
    private static List<Employee> createEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        
        // Thêm 4 nhân viên với mức lương khác nhau
        employees.add(new Employee(1, "Nguyen Van A", 800));
        employees.add(new Employee(2, "Tran Thi B", 1200));
        employees.add(new Employee(3, "Le Van C", 950));
        employees.add(new Employee(4, "Pham Thi D", 1500));
        
        // Có thể thêm nhân viên để test thêm
        // employees.add(new Employee(5, "Hoang Van E", 1100));
        // employees.add(new Employee(6, "Do Thi F", 850));
        
        return employees;
    }
    
    /**
     * Phương thức hiển thị danh sách nhân viên
     */
    private static void displayEmployees(List<Employee> employees) {
        System.out.println("Danh sách nhân viên:");
        System.out.println("┌────┬──────────────────┬──────────┐");
        System.out.println("│ ID │       Tên        │  Lương   │");
        System.out.println("├────┼──────────────────┼──────────┤");
        for (Employee emp : employees) {
            System.out.printf("│ %2d │ %-16s │ %8.1f │\n", 
                emp.getId(), emp.getName(), emp.getSalary());
        }
        System.out.println("└────┴──────────────────┴──────────┘");
    }
    
    /**
     * Phương thức in danh sách tên
     */
    private static void printNameList(List<String> names) {
        if (names.isEmpty()) {
            System.out.println("   Không có nhân viên nào thỏa mãn!");
        } else {
            for (int i = 0; i < names.size(); i++) {
                System.out.printf("   %d. %s\n", i + 1, names.get(i));
            }
        }
    }
}