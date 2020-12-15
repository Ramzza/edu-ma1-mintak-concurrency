package model;

public class OptimisticDataBase extends AbsDataBase {
    private int counter;

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

    public OptimisticDataBase takeOverDraft(OptimisticDataBase db) {
        if (this.counter != db.counter) {
            return null;
        }
        this.counter++;
        this.carName = db.carName;
        this.carPrice = db.carPrice;
        return this;
    }

}
