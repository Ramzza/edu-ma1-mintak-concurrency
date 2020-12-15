public class App {

    public static void main(String[] args) {
        MyThread R1 = new MyThread("Thread-1");
        R1.start();

        MyThread R2 = new MyThread("Thread-2");
        R2.start();
    }
}
