package dev.robingenz.capacitor.badge.handlers;

import android.content.Context;
import android.content.SharedPreferences;

import com.getcapacitor.Logger;

import dev.robingenz.capacitor.badge.BadgeConfig;
import me.leolin.shortcutbadger.ShortcutBadger;

public class ShortcutBadgerHandler implements BadgeHandler {

    private static final String STORAGE_KEY = "capacitor.badge";
    private Context context;
    private BadgeConfig config;

    public ShortcutBadgerHandler(Context context, BadgeConfig config) {
        this.config = config;
        if (ShortcutBadger.isBadgeCounterSupported(context)) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }
        boolean restoreCount = this.config.getPersist();
        if (restoreCount) {
            restore();
        }
    }

    public static boolean isSupported(Context context) {
        boolean isSupported;
        if (ShortcutBadger.isBadgeCounterSupported(context)) {
            isSupported = true;
        } else {
            context = context.getApplicationContext();
            isSupported = ShortcutBadger.isBadgeCounterSupported(context);
        }
        return isSupported;
    }

    public void handleOnResume() {
        try {
            boolean resetCount = this.config.getAutoClear();
            if (resetCount) {
                set(0);
            }
        } catch (Exception ex) {
            Logger.error(ex.getLocalizedMessage(), ex);
        }
    }

    public int get() {
        return getPrefs().getInt(STORAGE_KEY, 0);
    }

    public void set(int count) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putInt(STORAGE_KEY, count);
        editor.apply();
        ShortcutBadger.applyCount(context, count);
    }

    public void increase() {
        int count = get();
        set(count + 1);
    }

    public void decrease() {
        int count = get();
        if (count < 1) {
            return;
        }
        set(count - 1);
    }

    public void clear() {
        set(0);
    }

    public boolean isSupported() {
        int count = get();
        // Doing this check causes the side effect of resetting the counter if it's supported.
        boolean isSupported = ShortcutBadger.isBadgeCounterSupported(context);
        if (isSupported) {
            set(count);
        }
        return isSupported;
    }

    private void restore() {
        try {
            int count = get();
            ShortcutBadger.applyCount(context, count);
        } catch (Exception ex) {
            Logger.error(ex.getLocalizedMessage(), ex);
        }
    }

    private SharedPreferences getPrefs() {
        return context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE);
    }
}
