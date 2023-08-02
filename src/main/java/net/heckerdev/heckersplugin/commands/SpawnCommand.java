package net.heckerdev.heckersplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

//spawn command that sends the player to the world spawn
public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        //if the sender is a player
        if (sender instanceof Player) {
            Player player = (Player) sender;
            //if the player has permission to use the command
            if (player.hasPermission("testplugin.command.spawn")) {
                //teleport the player to the world spawn
                Location spawnLocation = player.getWorld().getSpawnLocation().add(0.5, 0, 0.5);
                spawnLocation.setPitch(0);
                spawnLocation.setYaw(-180);
                player.teleport(spawnLocation);
                player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "✔" + ChatColor.RESET + ChatColor.GREEN + " Successfully teleported to spawn!");
            } else {
                player.sendMessage(ChatColor.RED + "⚠ You do not have permission to use this command!");
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You can only execute this as a player!");
        }
        return true;
    }

}
