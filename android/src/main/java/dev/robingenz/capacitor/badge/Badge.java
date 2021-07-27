package dev.robingenz.capacitor.badge;

import static me.leolin.shortcutbadger.ShortcutBadger.isBadgeCounterSupported;

import android.content.Context;
import android.content.SharedPreferences;
import me.leolin.shortcutbadger.ShortcutBadger;

public class Badge {

    private static final String STORAGE_KEY = "capacitor.badge";
    private Context context;

    Badge(Context context) {
        if (isBadgeCounterSupported(context)) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }
        restore();
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

    private void restore() {
        int count = get();
        ShortcutBadger.applyCount(context, count);
    }

    private SharedPreferences getPrefs() {
        return context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE);
    }
}
