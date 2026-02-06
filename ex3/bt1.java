class WorkerThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread đang chạy…");
    }
}
class WorkerRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable đang chạy…");
    }
}
public class Main {
    public static void main(String[] args) {
        WorkerThread t1 = new WorkerThread();
        t1.start();
        WorkerRunnable workerRunnable = new WorkerRunnable();
        Thread t2 = new Thread(workerRunnable);
        t2.start();
    }
}