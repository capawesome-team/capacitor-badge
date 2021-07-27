package dev.robingenz.capacitor.badge;

public class BadgeConfig {

    private boolean persist = true;

    public boolean isPersisted() {
        return persist;
    }

    public void setPersist(boolean persist) {
        this.persist = persist;
    }
}
