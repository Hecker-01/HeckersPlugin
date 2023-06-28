package net.heckerdev.testplugin;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

public class BlockBreakEventListener implements Listener {

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        @NotNull Player player = event.getPlayer();
        @NotNull Block block = event.getBlock();
        player.sendMessage(player.getName() + " Broke " + block.getType());
    }
}