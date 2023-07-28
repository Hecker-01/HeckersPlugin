package net.heckerdev.testplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static org.bukkit.Bukkit.getLogger;

public class CommandKit implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("testplugin.command.kit")) {
                if (Objects.equals(args[0], "1") && player.hasPermission("testplugin.command.kit.1")) {
                    // Create a new ItemStack (type: diamond)
                    ItemStack diamond = new ItemStack(Material.DIAMOND);

                    // Create a new ItemStack (type: brick)
                    ItemStack bricks = new ItemStack(Material.BRICK, 20);

                    // Give the player our items (comma-separated list of all ItemStack)
                    player.getInventory().addItem(bricks, diamond);
                    player.sendMessage(ChatColor.GREEN + "Successfully received Kit \"1\"!");
                } else if (Objects.equals(args[0], "2") && player.hasPermission("testplugin.command.kit.2")) {
                    // Create a new ItemStack (type: diamond)
                    ItemStack diamond = new ItemStack(Material.DIAMOND);

                    // Create a new ItemStack (type: brick)
                    ItemStack bricks = new ItemStack(Material.BRICK, 20);

                    // Give the player our items (comma-separated list of all ItemStack)
                    player.getInventory().addItem(bricks, diamond);
                    player.sendMessage(ChatColor.GREEN + "Successfully received Kit \"2\"!");
                } else if (args.equals(null)) {
                    player.sendMessage(ChatColor.RED + "You need to specify kit to receive!");
                    player.sendMessage(ChatColor.GRAY + "/kit <Kit>");
                } else {
                    player.sendMessage(ChatColor.RED + "⚠ You do not have permission to receive this kit!");
                }
            } else player.sendMessage(ChatColor.RED + "⚠ You do not have permission to use this command!");

        } else getLogger().warning("You can only execute this as a player!");

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
