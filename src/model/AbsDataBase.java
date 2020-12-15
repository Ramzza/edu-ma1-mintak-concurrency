package model;

public abstract class AbsDataBase {
    public String carName;
    public int carPrice;

    public AbsDataBase getDraft(String owner) {
        return null;
    }

    public AbsDataBase takeOverDraft(String owner, AbsDataBase db) {
        return null;
    }
}
