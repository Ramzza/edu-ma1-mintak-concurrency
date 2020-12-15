import model.AbsDataBase;

public class MyThread implements Runnable {
    private Thread t;
    private String threadName;
    private AbsDataBase db;
    private AbsDataBase dbDraft;
    private int increment;

    MyThread(String name, int increment, AbsDataBase db) {
        threadName = name;
        this.increment = increment;
        this.db = db;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            if (!this.olvas()) {
                return;
            }
            Thread.sleep(10);
            if (!this.ir()) {
                return;
            }
            Thread.sleep(10);
            if (!this.olvas()) {
                return;
            }
            Thread.sleep(10);
            if (!this.ir()) {
                return;
            }
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
    }

    private boolean olvas() {
        this.dbDraft = db.getDraft(threadName);

        if (this.dbDraft == null) {
            System.out.println(threadName + " olvas - sikertelen");
            return false;
        } else {
            System.out.println(threadName + " olvas: " + dbDraft.carName + ", " + dbDraft.carPrice);
            return true;
        }
    }

    private boolean ir() {
        this.dbDraft.carPrice += this.increment;
        this.dbDraft = this.db.takeOverDraft(this.threadName, this.dbDraft);
        if (this.dbDraft == null) {
            System.out.println(threadName + " ir - sikertelen");
            return false;
        } else {
            System.out.println(threadName + " ir: " + dbDraft.carName + ", " + dbDraft.carPrice);
            return true;
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}