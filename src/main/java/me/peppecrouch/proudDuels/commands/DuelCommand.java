package me.peppecrouch.proudDuels.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DuelCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        Player target;

        if (sender instanceof Player player) {
            if (command.getName().equalsIgnoreCase("duel")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.RED + "/duel <player>");
                    return true;
                }
                if (args.length == 1) {
                    target = Bukkit.getPlayer(args[0]);
                    if (target.isOnline()) {
                        target.sendMessage(ChatColor.RED + "Player " + ChatColor.YELLOW + args[0] + " is online.");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
