package me.peppecrouch.proudDuels;

import me.peppecrouch.proudDuels.commands.DuelCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ProudDuels extends JavaPlugin {

    private ProudDuels instance;

    @Override
    public void onEnable() {
        getCommand("duel").setExecutor(new DuelCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ProudDuels getInstance() {return instance;}

}
