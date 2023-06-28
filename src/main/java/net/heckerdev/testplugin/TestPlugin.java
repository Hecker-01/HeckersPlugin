package net.heckerdev.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        // Registering commands.
        this.getCommand("kit").setExecutor(new CommandKit());
        this.getCommand("book").setExecutor(new CommandBook());

        // registering listeners.

        String placeMessage = getConfig().getString("Listeners.PlaceMessage");
        if (Objects.equals(placeMessage, "true")) {Bukkit.getPluginManager().registerEvents(new BlockPlaceEventListener(), this);
        } else if (!Objects.equals(placeMessage, "false")) {
            getLogger().warning("Error in config.yml: Listener.PlaceMessage wasn't a boolean, reverting to true...");
            Bukkit.getPluginManager().registerEvents(new BlockPlaceEventListener(), this);
            getConfig().set("Listeners.PlaceMessage", true);
            saveConfig();
        }
        String breakMessage = getConfig().getString("Listeners.BreakMessage");
        if (Objects.equals(breakMessage, "true")) {Bukkit.getPluginManager().registerEvents(new BlockBreakEventListener(), this);
        } else if (!Objects.equals(breakMessage, "false")) {
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
