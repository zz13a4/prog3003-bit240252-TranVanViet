package bt.java.pkg3;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== KHỞI CHẠY THREAD ===\n");
        
        // Khởi chạy WorkerThread
        WorkerThread thread1 = new WorkerThread();
        thread1.start();
        
        // Khởi chạy WorkerRunnable
        WorkerRunnable runnable = new WorkerRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        
        // Đợi cả hai hoàn thành
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n=== CẢ HAI ĐÃ HOÀN THÀNH! ===");
    }
}