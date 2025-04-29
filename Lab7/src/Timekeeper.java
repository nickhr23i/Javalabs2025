public class Timekeeper extends Thread {
    public void run() {
        long time = 0, start_time = System.currentTimeMillis();
        while (time < 10000) {
            time = System.currentTimeMillis() - start_time;

        }
        interrupt();
    }
}
