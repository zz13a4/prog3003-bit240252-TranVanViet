import java.util.HashSet;
public class bai6 {
    public static void main(String[] args) {
        // 1
        int[] arr = {5, 2, 9, 2, 5, 8, 1};
        System.out.println("Mảng ban đầu:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        // 2
        HashSet<Integer> uniqueSet = new HashSet<>();
        for (int num : arr) {
            uniqueSet.add(num);
        }
        // 3
        System.out.println("Các phần tử duy nhất trong HashSet:");
        for (int num : uniqueSet) {
            System.out.print(num + " ");
        }
        System.out.println(); 
        // 4. Giải thích tại sao thứ tự in ra có thể không giống mảng ban đầu
        /*
         * Giải thích:
         * - HashSet trong Java không duy trì thứ tự của các phần tử khi thêm vào.
         * - Nó lưu trữ và truy xuất phần tử.
         * - Các phần tử được lưu trữ dựa trên mã của chúng và 
         *   không đảm bảo thứ tự chèn vào.
         * - HashSet ưu tiên hiệu suất truy cập nhanh O(1) hơn là duy trì thứ tự.
         * - Thứ tự có thể thay đổi tùy thuộc vào dung lượng bảng và phương thức.
         * - Để giữ thứ tự chèn, có thể sử dụng LinkedHashSet.
         * - Để sắp xếp tự động, có thể sử dụng TreeSet.
         */
    }
}