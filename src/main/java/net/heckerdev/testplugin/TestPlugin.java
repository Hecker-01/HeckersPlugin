package net.heckerdev.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        // Registering commands.
        this.getCommand("kit").setExecutor(new CommandKit());
        this.getCommand("book").setExecutor(new CommandBook());

        // registering listeners.
        boolean placeMessage = getConfig().getBoolean("Listeners.PlaceMessage");
        if (placeMessage) {Bukkit.getPluginManager().registerEvents(new BlockPlaceEventListener(), this);}
        boolean breakMessage = getConfig().getBoolean("Listeners.BreakMessage");
        if (breakMessage) {Bukkit.getPluginManager().registerEvents(new BlockBreakEventListener(), this);}

        // Loaded message.
        getLogger().info("Successfully loaded TestPlugin!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye!");
    }
}
