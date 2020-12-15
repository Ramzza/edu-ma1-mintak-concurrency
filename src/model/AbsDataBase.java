package model;

public abstract class AbsDataBase {
    protected int counter;
    protected String carName;
    protected int carPrice;

    public AbsDataBase getDraft(String owner) {
        return null;
    }

    public void takeOverDraft(String owner, AbsDataBase db) {

    }
}
