import model.DataBaseSimulator;

public class MyThread implements Runnable {
    private Thread t;
    private String threadName;
    private DataBaseSimulator db;

    MyThread(String name, DataBaseSimulator db) {
        threadName = name;
        this.db = db;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        // try {
        for (int i = 4; i > 0; i--) {
            int iCounter = db.getCounter();
            System.out.println("Thread: " + threadName + ", " + i + " ~~ counter: " + iCounter);
            db.setCounter(iCounter + 1);
            System.out.println("Thread: " + threadName + ", " + i + " ~~ counter increased to: " + (iCounter + 1));
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