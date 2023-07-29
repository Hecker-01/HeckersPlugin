package net.heckerdev.heckersplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class KitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!sender.hasPermission("testplugin.command.kit")) {
                player.sendMessage(ChatColor.RED + "⚠ You do not have permission to use this command!");
                return true;
            } else if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "⚠ You need to specify a kit to receive!" + ChatColor.RESET + ChatColor.GRAY + " /kit " + ChatColor.UNDERLINE + "<kit>");
                return true;
            } else {
                switch (args[0]) {
                    case "kit1":
                        if (player.hasPermission("testplugin.command.kit.kit1")) {
                            ItemStack diamond = new ItemStack(Material.DIAMOND);

                            ItemStack bricks = new ItemStack(Material.BRICK, 20);

                            player.getInventory().addItem(bricks, diamond);
                            player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "✔" + ChatColor.RESET + ChatColor.GREEN + " Successfully received Kit \"" + args[0] + "\"!");
                        } else {
                            player.sendMessage(ChatColor.RED + "⚠ You do not have permission to receive this kit!");
                        }
                        return true;
                    case "kit2":
                        if (player.hasPermission("testplugin.command.kit.kit2")) {
                            ItemStack wood = new ItemStack(Material.OAK_PLANKS);

                            player.getInventory().addItem(wood);
                            player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "✔" + ChatColor.RESET + ChatColor.GREEN + " Successfully received Kit \"" + args[0] + "\"!");
                        } else {
                            player.sendMessage(ChatColor.RED + "⚠ You do not have permission to receive this kit!");
                        }
                        return true;
                    case "help":
                        player.sendMessage("A help menu will implemented soon!");
                        return true;
                    default:
                        player.sendMessage(ChatColor.RED + "⚠ Kit \"" + args[0] + "\" Does not exist!");
                        return true;
                }
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You can only execute this as a player");
            return true;
        }
    }
}
