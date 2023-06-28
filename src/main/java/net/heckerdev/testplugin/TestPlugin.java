package net.heckerdev.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        // Register our command "kit" (set an instance of your command class as executor)
        this.getCommand("kit").setExecutor(new CommandKit());
        this.getCommand("book").setExecutor(new CommandBook());
        Bukkit.getPluginManager().registerEvents(new BlockBreakEventListener(), this);
        getLogger().info("Successfully loaded commands!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye!");
    }
}
