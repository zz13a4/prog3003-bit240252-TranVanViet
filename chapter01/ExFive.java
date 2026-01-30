import java.util.LinkedList;
public class ExFive {
    public static void main(String[] args) {
        // 1
        LinkedList<Integer> queue = new LinkedList<>();
        // 2
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Danh sách sau khi thêm 10, 20, 30: " + queue);
        // 3
        queue.addFirst(5);
        queue.addLast(40);
        System.out.println("Sau khi thêm 5 vào đầu và 40 vào cuối: " + queue);
        // 4
        if (!queue.isEmpty()) {
            queue.removeFirst();
        }
        if (!queue.isEmpty()) {
            queue.removeLast();
        }
        System.out.println("Danh sách sau khi xóa đầu và cuối: " + queue);
    }
}