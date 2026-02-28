package me.peppecrouch.proudDuels;

import org.bukkit.plugin.java.JavaPlugin;

public final class ProudDuels extends JavaPlugin {

    private ProudDuels instance;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("duel").setExecutor(new DuelCommand());
        getConfig().options().copyDefaults(true);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ProudDuels getInstance() {return instance;}

}
