import model.AbsDataBase;
import model.DataBaseSimulator;

public class MyThread implements Runnable {
    private Thread t;
    private String threadName;
    private AbsDataBase db;

    MyThread(String name, AbsDataBase db) {
        threadName = name;
        this.db = db;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        // try {
        for (int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            // if (threadName == "Thread-1") {
            // Thread.sleep(10);
            // } else {
            // Thread.sleep(150);
            // }
        }
        // } catch (InterruptedException e) {
        // System.out.println("Thread " + threadName + " interrupted.");
        // }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}