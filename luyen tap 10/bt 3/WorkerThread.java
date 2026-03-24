package bt.java.pkg3;

public class WorkerThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread đang chạy... - Lần " + i);
            try {
                Thread.sleep(500); // Dừng 0.5 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}