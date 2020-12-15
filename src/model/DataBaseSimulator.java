package model;

public class DataBaseSimulator {
    private int counter;
    private String carName;
    private int carPrice;

    public DataBaseSimulator(int counter, String carName, int carPrice) {
        this.counter = counter;
        this.carName = carName;
        this.carPrice = carPrice;
    }

    public DataBaseSimulator getDraft() {
        return new DataBaseSimulator(this.counter, this.carName, this.carPrice);
    }

    public void takeOverDraft(DataBaseSimulator db) {
        this.counter = db.counter;
        this.carName = db.carName;
        this.carPrice = db.carPrice;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
