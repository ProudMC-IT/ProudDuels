package me.peppecrouch.proudDuels.commands;

import me.peppecrouch.proudDuels.ProudDuels;
import me.peppecrouch.proudDuels.utils.MiniMessageUtil;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class DuelCommand implements CommandExecutor {

    private final ProudDuels instance;
    private final MiniMessageUtil miniMessage;
    HashMap<UUID, UUID> dueling = new HashMap<>();
    HashSet<UUID> duelsAlive = new HashSet<>();

    public DuelCommand(ProudDuels instance, MiniMessage miniMessage) {
        this.instance = instance;
        this.miniMessage = (MiniMessageUtil) miniMessage;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(miniMessage.color(instance.getConfig().getString("messages.no-console")));
            return true;
        }
        if (command.getName().equalsIgnoreCase("duel")) {
            if (args.length == 0) {
                player.sendMessage(miniMessage.color(instance.getConfig().getString("messages.no-args")));
                return true;
            }
        }
        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            assert target != null;
            if (!(dueling.containsKey(target.getUniqueId()))) {
                target.sendMessage(miniMessage.color(instance.getConfig().getString("messages.duel-request")));
                if (!(duelsAlive.contains(target.getUniqueId()))) {
                    duelsAlive.add(target.getUniqueId());
                    dueling.put(target.getUniqueId(), player.getUniqueId());
                    player.sendMessage(miniMessage.color(instance.getConfig().getString("messages.fight-started")));
                    target.sendMessage(miniMessage.color(instance.getConfig().getString("messages.fight-started")));
                }
                else {
                    player.sendMessage(miniMessage.color(instance.getConfig().getString("messages.player-isDueling")));
                }
                return true;
            }
            else {
                player.sendMessage(miniMessage.color(instance.getConfig().getString("messages.player-isDueling")));
            }
        }
        return false;
    }
}
