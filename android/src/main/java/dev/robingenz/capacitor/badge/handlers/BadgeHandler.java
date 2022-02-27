package dev.robingenz.capacitor.badge.handlers;

public interface BadgeHandler {
    void handleOnResume();
    int get();
    void set(int count);
    void increase();
    void decrease();
    void clear();
    boolean isSupported();
}
