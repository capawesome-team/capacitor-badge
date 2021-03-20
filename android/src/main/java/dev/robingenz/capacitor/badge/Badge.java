package dev.robingenz.capacitor.badge;

import android.content.Context;
import android.content.SharedPreferences;
import me.leolin.shortcutbadger.ShortcutBadger;

public class Badge {

    private static final String STORAGE_KEY = "capacitor.badge";
    private Context context;

    Badge(Context context) {
        this.context = context;
        restore();
    }

    public Integer get() {
        return getPrefs().getInt(STORAGE_KEY, 0);
    }

    public void set(Integer count) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putInt(STORAGE_KEY, count);
        editor.apply();
        ShortcutBadger.applyCount(context, count);
    }

    public void clear() {
        set(0);
    }

    private void restore() {
        Integer count = get();
        ShortcutBadger.applyCount(context, count);
    }

    private SharedPreferences getPrefs() {
        return context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE);
    }
}
