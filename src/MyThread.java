import model.AbsDataBase;

public class MyThread implements Runnable {
    private Thread t;
    private String threadName;
    private AbsDataBase db;
    private AbsDataBase dbDraft;
    private int increment;

    MyThread(String name, int increment, AbsDataBase db) {
        this.threadName = name;
        this.increment = increment;
        this.db = db;
    }

    public void run() {
        try {
            if (!this.olvas()) {
                // return;
            }
            Thread.sleep(1);
            if (!this.ir()) {
                // return;
            }
            Thread.sleep(1);
            if (!this.olvas()) {
                // return;
            }
            Thread.sleep(1);
            if (!this.ir()) {
                // return;
            }
            Thread.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(this.threadName + " exception");
        }
    }

    private boolean olvas() {
        this.dbDraft = db.getDraft(this.threadName);

        if (this.dbDraft == null) {
            System.out.println(this.threadName + " olvas - sikertelen");
            return false;
        } else {
            System.out.println(this.threadName + " olvas: " + this.dbDraft.carName + ", " + this.dbDraft.carPrice);
            return true;
        }
    }

    private boolean ir() {
        if (this.dbDraft != null) {
            this.dbDraft.carPrice += this.increment;
            this.dbDraft = this.db.takeOverDraft(this.threadName, this.dbDraft);
        }

        if (this.dbDraft == null) {
            System.out.println(this.threadName + " ir - sikertelen");
            return false;
        } else {
            System.out.println(this.threadName + " ir: " + this.dbDraft.carName + ", " + this.dbDraft.carPrice);
            return true;
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, this.threadName);
            t.start();
        }
    }
}