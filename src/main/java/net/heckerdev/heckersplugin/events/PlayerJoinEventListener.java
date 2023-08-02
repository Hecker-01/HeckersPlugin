package net.heckerdev.heckersplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Bukkit.getWorld;

public class PlayerJoinEventListener implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        @NotNull Player player = event.getPlayer();
        World world = getWorld("world");
        Location location = new Location(world, 0, 0, 0, 0.0F, 0.0F);
        player.teleport(location);
        player.sendMessage(ChatColor.GREEN + "Teleported to: " + location);
    }
}
