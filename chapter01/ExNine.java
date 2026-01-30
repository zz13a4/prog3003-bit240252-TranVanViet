import java.util.Map;
import java.util.TreeMap;
import java.util.SortedMap;
public class bai9 {
    public static void main(String[] args) {
        // 1
        TreeMap<String, Double> products = new TreeMap<>();
        // 2
        products.put("Laptop", 1500.0);
        products.put("Mouse", 25.0);
        products.put("Keyboard", 50.0);
        // 3
        System.out.println("Danh sách sản phẩm (tự động sắp xếp theo tên):");
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            System.out.println("  " + entry.getKey() + ": $" + entry.getValue());
        }
        // 4
        SortedMap<String, Double> subProducts = products.subMap("K", "N"); 
        System.out.println("\nCác sản phẩm có tên từ 'K' đến 'M' (K ≤ tên < N):");
        if (subProducts.isEmpty()) {
            System.out.println("  Không có sản phẩm nào trong khoảng này");
        } else {
            for (Map.Entry<String, Double> entry : subProducts.entrySet()) {
                System.out.println("  " + entry.getKey() + ": $" + entry.getValue());
            }
        }
    }
}