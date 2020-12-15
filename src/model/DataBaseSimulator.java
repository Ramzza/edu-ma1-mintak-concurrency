package model;

import locks.PessimisticLockManager;

public class DataBaseSimulator {
    private int counter;
    private String carName;
    private int carPrice;
    private PessimisticLockManager lockManager;

    public DataBaseSimulator(int counter, String carName, int carPrice) {
        this.counter = counter;
        this.carName = carName;
        this.carPrice = carPrice;
        this.lockManager = PessimisticLockManager.getPessimisticLockManager();
    }

    public DataBaseSimulator getDraft(String owner) {
        boolean success = this.lockManager.setLock(owner, true);
        if (!success) {
            return null;
        }
        return new DataBaseSimulator(this.counter, this.carName, this.carPrice);
    }

    public void takeOverDraft(String owner, DataBaseSimulator db) {
        this.counter = db.counter;
        this.carName = db.carName;
        this.carPrice = db.carPrice;
        this.lockManager.setLock(owner, false);
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
