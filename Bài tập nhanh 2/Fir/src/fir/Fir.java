package fir ;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Fir {
    public static void main(String[] args) {
        // Task 1: Xác thực khách hàng
        CompletableFuture<String> authTask = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("✓ Xác thực khách hàng thành công!");
                return "Đã xác thực";
            } catch (InterruptedException e) {
                return "Xác thực thất bại";
            }
        });

        // Task 2: Xuất vé xem phim
        CompletableFuture<String> ticketTask = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("✓ Xuất vé xem phim thành công!");
                return "Vé đã được in";
            } catch (InterruptedException e) {
                return "Xuất vé thất bại";
            }
        });

        // Kết hợp 2 task
        CompletableFuture<String> combined = authTask.thenCombine(ticketTask,
                (authResult, ticketResult) -> {
                    return "KẾT QUẢ:\n- " + authResult + "\n- " + ticketResult;
                });

        // Chờ kết quả
        combined.thenAccept(System.out::println).join();
    }
}