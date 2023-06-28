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
        try {
            String placeMessage = getConfig().getString("Listeners.PlaceMessage");
            if (placeMessage == "true") {Bukkit.getPluginManager().registerEvents(new BlockPlaceEventListener(), this);} else if (placeMessage == "false") {return;} else {getLogger().warning("Error in config.yml: Listener.PlaceMessage wasn't a boolean, reverting to true...");Bukkit.getPluginManager().registerEvents(new BlockPlaceEventListener(), this);getConfig().set("Listeners.PlaceMessage", true);saveConfig();};
        } catch (Exception e) {
            getLogger().warning("Error in config.yml: Listener.PlaceMessage wasn't a boolean, reverting to true...");
            Bukkit.getPluginManager().registerEvents(new BlockPlaceEventListener(), this);
            getConfig().set("Listeners.PlaceMessage", true);
            saveConfig();
        }
        try {
            String breakMessage = getConfig().getString("Listeners.BreakMessage");
            if (breakMessage == "true") {Bukkit.getPluginManager().registerEvents(new BlockBreakEventListener(), this);} else if (breakMessage == "false") {return;} else {getLogger().warning("Error in config.yml: Listener.BreakMessage wasn't a boolean, reverting to true...");Bukkit.getPluginManager().registerEvents(new BlockBreakEventListener(), this);getConfig().set("Listeners.BreakMessage", true);saveConfig();};
        } catch (Exception e) {
            getLogger().warning("Error in config.yml: Listener.BreakMessage wasn't a boolean, reverting to true...");
            Bukkit.getPluginManager().registerEvents(new BlockBreakEventListener(), this);
            getConfig().set("Listeners.BreakMessage", true);
            saveConfig();
        }

        // Loaded message.
        getLogger().info("Successfully loaded TestPlugin!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye!");
    }
}
