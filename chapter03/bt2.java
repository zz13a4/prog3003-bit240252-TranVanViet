class NumberThread extends Thread {
    public NumberThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + ": " + i);
            try {
                Thread.sleep(100);t
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            NumberThread thread = new NumberThread("Thread-" + i);
            thread.start();
        }
    }
}