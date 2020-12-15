package model;

import locks.PessimisticLockManager;

public class DataBaseSimulator extends AbsDataBase {
    private PessimisticLockManager lockManager;

    public DataBaseSimulator(String carName, int carPrice) {
        this.carName = carName;
        this.carPrice = carPrice;
        this.lockManager = PessimisticLockManager.getPessimisticLockManager();
    }

    public DataBaseSimulator getDraft(String owner) {
        boolean success = this.lockManager.setLock(owner, true);
        if (!success) {
            return null;
        }
        return new DataBaseSimulator(this.carName, this.carPrice);
    }

    public void takeOverDraft(String owner, DataBaseSimulator db) {
        this.carName = db.carName;
        this.carPrice = db.carPrice;
        this.lockManager.setLock(owner, false);
    }
}
