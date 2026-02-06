import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<int[]> futureArray = CompletableFuture.supplyAsync(() -> {
            System.out.println("B1: Đang cung cấp mảng..." + Thread.currentThread().getName() + ")");
            return new int[]{1, 2, 5, 3, 100};
        });
        CompletableFuture<int[]> futureFilteredSorted = futureArray.thenApplyAsync(array -> {
            System.out.println("B2: Đang lọc số lẻ và sắp xếp..." + Thread.currentThread().getName() + ")");
            return Arrays.stream(array)
                    .filter(n -> n % 2 != 0)
                    .sorted()
                    .toArray();
        });
        CompletableFuture<String> futureResultString = futureFilteredSorted.thenApplyAsync(sortedArray -> {
            System.out.println("B3: Đang chuyển thành chuỗi..." + Thread.currentThread().getName() + ")");
            String arrayString = Arrays.stream(sortedArray)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "));
            return "Kết quả là: [" + arrayString + "]";
        });
        futureResultString.thenAccept(result -> {
            System.out.println("B4: In kết quả cuối cùng..." + Thread.currentThread().getName() + ")");
            System.out.println(result);
        });
        futureResultString.join();
    }
}