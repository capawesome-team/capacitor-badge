package dev.robingenz.capacitor.badge;

import static me.leolin.shortcutbadger.ShortcutBadger.isBadgeCounterSupported;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import com.getcapacitor.Logger;

import dev.robingenz.capacitor.badge.handlers.BadgeHandler;
import dev.robingenz.capacitor.badge.handlers.NotificationDotHandler;
import dev.robingenz.capacitor.badge.handlers.ShortcutBadgerHandler;
import me.leolin.shortcutbadger.ShortcutBadger;

public class Badge {

    private static final String STORAGE_KEY = "capacitor.badge";
    private BadgeHandler handler;

    Badge(Context context, BadgeConfig config) {
        if (ShortcutBadgerHandler.isSupported(context)) {
            this.handler = new ShortcutBadgerHandler(context, config);
        } else {
            this.handler = new NotificationDotHandler(context, config);
        }
    }

    public void handleOnResume() {
        this.handler.handleOnResume();
    }

    public int get() {
        return this.handler.get();
    }

    public void set(int count) {
        this.handler.set(count);
    }

    public void increase() {
        this.handler.increase();
    }

    public void decrease() {
        this.handler.decrease();
    }

    public void clear() {
        this.handler.clear();
    }

    public boolean isSupported() {
        return this.handler.isSupported();
    }
}
