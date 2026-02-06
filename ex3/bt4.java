import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
public class OrderProcessingSystem {
    public static void main(String[] args) {
        System.out.println("Bắt đầu xử lý đơn hàng...");
        CompletableFuture<Void> checkAvailability = CompletableFuture.runAsync(() -> {
            System.out.println("Tác vụ 1:Đang kiểm tra tính khả dụng của sản phẩm...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Tác vụ 1: kiểm tra tính khả dụng thành công!");
        });

        CompletableFuture<Void> processPayment = CompletableFuture.runAsync(() -> {
            System.out.println("Tác vụ 2:Đang xử lý thanh toán...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Tác vụ 2:hanh toán hoàn thành!");
        });
        CompletableFuture<Void> arrangeShipping = CompletableFuture.runAsync(() -> {
            System.out.println("Tác vụ 3: Đang sắp xếp vận chuyển...");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Tác vụ 3: đã được sắp xếp vận chuyển");
        });
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                checkAvailability,
                processPayment,
                arrangeShipping
        );

        allTasks.thenRun(() -> {
            System.out.println("\n Tất cả tác vụ đã hoàn thành!");
            System.out.println(" Đơn hàng đã được xử lý thành công và sẵn sàng giao!");
        }).join();
        System.out.println("\n Kết thúc chương trình.");
    }
}