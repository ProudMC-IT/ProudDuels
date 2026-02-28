package me.peppecrouch.proudDuels.commands;

import me.peppecrouch.proudDuels.ProudDuels;
import me.peppecrouch.proudDuels.utils.MiniMessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public class DuelCommand implements CommandExecutor {

    HashMap<UUID, Boolean> isPending = new HashMap<>();
    HashMap<UUID, UUID> inDuel = new HashMap<>();
    private final ProudDuels instance;
    private final MiniMessageUtil miniMessage;

    public DuelCommand(ProudDuels instance, MiniMessageUtil miniMessage) {
        this.instance = instance;
        this.miniMessage = miniMessage;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player Player)) {
            sender.sendMessage(ChatColor.RED + "Solo i giocatori possono eseguire questo comando.");
        }

        assert sender instanceof Player;
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                player.sendMessage(miniMessage.color("<red>Giocatore non trovato."));
                return true;
            }
            if (target == player) {
                player.sendMessage(miniMessage.color("<red>Non puoi duellare te stesso"));
                return true;
            }
            if (args[0].equals("accept") && args[1].equals(player.getName())) {
                isPending.put(player.getUniqueId(), true);
                inDuel.put(player.getUniqueId(), target.getUniqueId());
                player.sendMessage(miniMessage.color(target + "<green> ha accettato la tua richiesta di duello!"));
                target.sendMessage(miniMessage.color("<green>Hai accettato la richiesta di duello di " + player.getName() + "!"));
                return true;
            }
        return false;
    }
}
