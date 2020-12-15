import model.AbsDataBase;
import model.DataBaseSimulator;
import model.OptimisticDataBase;

public class App {

    public static void main(String[] args) {
        boolean opt = true;
        AbsDataBase db;
        if (opt) {
            db = new OptimisticDataBase("Ford", 5000);
        } else {
            db = new DataBaseSimulator("Ford", 5000);
        }

        MyThread t1 = new MyThread("Janos", 100, db);
        MyThread t2 = new MyThread("Eszter", 33, db);
        MyThread t3 = new MyThread("Andras", 324, db);
        MyThread t4 = new MyThread("Kata", 663, db);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
