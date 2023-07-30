package net.heckerdev.heckersplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;


public class GroupsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("testplugin.command.groups")) {
            sender.sendMessage(ChatColor.RED + "⚠ You do not have permission to use this command!");
            return true;
        } else if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                String[] groups = plugin.getPermissions().getPlayerGroups(player);
                sender.sendMessage(ChatColor.GREEN + "Your groups are: " + Arrays.toString(groups));
            } else {
                sender.sendMessage(ChatColor.RED + "You need to specify a player to get their groups!" + ChatColor.RESET + ChatColor.GRAY + " Usage: /groups " + ChatColor.UNDERLINE + "<player>" + ChatColor.RESET);
                sender.sendMessage(ChatColor.YELLOW + "You can also just use " + ChatColor.UNDERLINE + "/groups" + ChatColor.RESET + ChatColor.YELLOW + " to get your own groups, but you need to be a player to do that!" + ChatColor.RESET + ChatColor.GRAY + " Usage: " + ChatColor.UNDERLINE + "/groups");
            }
            return true;
        } else {
            Player player = Bukkit.getPlayer(args[0]);
            if (player != null) {
                String[] groups = plugin.getPermissions().getPlayerGroups(player);
                sender.sendMessage(ChatColor.GREEN + player.getName() + "'s groups are: " + Arrays.toString(groups));
            } else {
                sender.sendMessage(ChatColor.RED + args[0] + " is not a valid player! - Make sure the player is online!" + ChatColor.RESET + ChatColor.GRAY + " Usage: /groups " + ChatColor.UNDERLINE + "<player>" + ChatColor.RESET);
            }
            return true;
        }
    }

    private final HeckersPlugin plugin;

    public GroupsCommand(HeckersPlugin plugin) {
        this.plugin = plugin;

    }
}


