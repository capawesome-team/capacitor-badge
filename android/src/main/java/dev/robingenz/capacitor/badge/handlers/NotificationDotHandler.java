package dev.robingenz.capacitor.badge.handlers;

import android.content.Context;

import dev.robingenz.capacitor.badge.BadgeConfig;
import me.leolin.shortcutbadger.ShortcutBadger;

public class NotificationDotHandler implements BadgeHandler {
    private Context context;
    private BadgeConfig config;

    public NotificationDotHandler(Context context, BadgeConfig config) {
        this.config = config;
        this.context = context;
    }
}
