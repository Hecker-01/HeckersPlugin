package net.heckerdev.testplugin;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.jetbrains.annotations.NotNull;

public class BlockPlaceEventListener implements Listener {

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        @NotNull Player player = event.getPlayer();
        @NotNull Block block = event.getBlock();
        player.sendMessage(ChatColor.YELLOW + player.getName() + ChatColor.YELLOW + " Placed " + ChatColor.YELLOW + block.getType());
    }
}