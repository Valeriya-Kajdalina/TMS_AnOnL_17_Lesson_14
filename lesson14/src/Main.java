class CustomThread extends Thread {
    private String threadName;

    public CustomThread(final String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName + " - начал свою работу");
        try {
            // происходит некая логика
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + " - закончил свою работу");
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            CustomThread t1 = new CustomThread("Первый поток");
            t1.start();
            t1.join();

            CustomThread t2 = new CustomThread("Второй поток");
            t2.start();
            t2.join();

            CustomThread t3 = new CustomThread("Третий поток");
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}