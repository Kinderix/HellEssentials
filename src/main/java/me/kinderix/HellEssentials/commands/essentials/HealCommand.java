package me.kinderix.HellEssentials.commands.essentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player target;

        if (args.length == 0 && !(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must specify a player.");
            return true;
        }

        if (args.length == 0) {
            target = (Player) sender; // This is safe because we already made sure the sender is a Player.
        }

        else {
            target = Bukkit.getServer().getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(ChatColor.RED + "Cannot find player " + args[0] + ".");
                return true;
            }
        }

        target.setHealth(target.getMaxHealth());

        sender.sendMessage(ChatColor.GREEN + "You have healed " + target.getName() + ".");
        target.sendMessage(ChatColor.GREEN + "You have been healed by " + sender.getName() + ".");

        return true;
    }
}

