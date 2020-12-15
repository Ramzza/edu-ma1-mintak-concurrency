package model;

public class OptimisticDataBase {
    private int counter;
    private String carName;
    private int carPrice;

    public OptimisticDataBase(int counter, String carName, int carPrice) {
        this.counter = 0;
        this.carName = carName;
        this.carPrice = carPrice;
    }

    public OptimisticDataBase(String carName, int carPrice) {
        this.carName = carName;
        this.carPrice = carPrice;
    }

    public OptimisticDataBase getDraft(String owner) {
        return new OptimisticDataBase(this.counter, this.carName, this.carPrice);
    }

    public boolean takeOverDraft(OptimisticDataBase db) {
        if (this.counter != db.counter) {
            return false;
        }
        this.counter++;
        this.carName = db.carName;
        this.carPrice = db.carPrice;
        return true;
    }

}
