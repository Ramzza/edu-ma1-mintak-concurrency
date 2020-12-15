import model.DataBaseSimulator;

public class App {

    public volatile int iCounter = 0;

    public static void main(String[] args) {
        DataBaseSimulator db = new DataBaseSimulator("Ford", 5000);
        MyThread R1 = new MyThread("Thread-1", db);
        R1.start();

        MyThread R2 = new MyThread("Thread-2", db);
        R2.start();
    }
}
