package net.heckerdev.heckersplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HeckersPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        // Registering commands.
        this.getCommand("kit").setExecutor(new KitCommand());
        this.getCommand("book").setExecutor(new CommandBook());

        // registering listeners.
        boolean placeMessage = getConfig().getBoolean("Listeners.PlaceMessage");
        if (placeMessage) {
            Bukkit.getPluginManager().registerEvents(new BlockPlaceEventListener(), this);
        }
        boolean breakMessage = getConfig().getBoolean("Listeners.BreakMessage");
        if (breakMessage) {
            Bukkit.getPluginManager().registerEvents(new BlockBreakEventListener(), this);
        }

        // Loaded message.
        getLogger().info("Successfully loaded HeckersPlugin!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye!");
    }
}
