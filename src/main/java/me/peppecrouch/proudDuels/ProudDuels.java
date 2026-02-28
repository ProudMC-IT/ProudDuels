package me.peppecrouch.proudDuels;

import me.peppecrouch.proudDuels.commands.DuelCommand;
import me.peppecrouch.proudDuels.utils.MiniMessageUtil;import net.kyori.adventure.text.minimessage.MiniMessage;import org.bukkit.plugin.java.JavaPlugin;

public final class ProudDuels extends JavaPlugin {

    private ProudDuels instance;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("duel").setExecutor(new DuelCommand(this, new MiniMessageUtil(MiniMessage.miniMessage())));
        getConfig().options().copyDefaults(true);
    }

    @Override
    public void onDisable() {
    }

    public ProudDuels getInstance() {return instance;}

}
