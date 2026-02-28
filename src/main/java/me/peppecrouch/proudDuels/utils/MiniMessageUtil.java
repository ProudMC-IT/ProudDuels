package me.peppecrouch.proudDuels.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class MiniMessageUtil {

    private final MiniMessage miniMessage;


    public MiniMessageUtil(MiniMessage miniMessage) {
        this.miniMessage = miniMessage;
    }

    public Component color(String message) {
        return miniMessage.deserialize(message);
    }
}
