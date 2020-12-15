package locks;

public class PessimisticLockManager {
    public static PessimisticLockManager instance = null;

    private boolean isLocked;
    private String lockOwner;

    private PessimisticLockManager() {
        this.isLocked = false;
        this.lockOwner = "";
    }

    public boolean setLock(String owner, boolean isLocked) {
        if (this.isLocked && this.lockOwner != owner) {
            return false;
        }

        if (isLocked) {
            this.lockOwner = owner;
            this.isLocked = true;
        } else {
            this.lockOwner = "";
            this.isLocked = false;
        }

        return true;
    }

    public static PessimisticLockManager getPessimisticLockManager() {
        if (instance == null) {
            instance = new PessimisticLockManager();
        }

        return instance;
    }
}
