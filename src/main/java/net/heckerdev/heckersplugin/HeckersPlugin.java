package net.heckerdev.heckersplugin;

import net.heckerdev.heckersplugin.commands.BookCommand;
import net.heckerdev.heckersplugin.commands.GroupsCommand;
import net.heckerdev.heckersplugin.commands.KitCommand;
import net.heckerdev.heckersplugin.commands.SpawnCommand;
import net.heckerdev.heckersplugin.events.BlockBreakEventListener;
import net.heckerdev.heckersplugin.events.BlockPlaceEventListener;
import net.heckerdev.heckersplugin.events.PlayerJoinEventListener;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class HeckersPlugin extends JavaPlugin {

    private static Permission perms = null;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        // Registering commands.
        Objects.requireNonNull(this.getCommand("kit")).setExecutor(new KitCommand());
        Objects.requireNonNull(this.getCommand("book")).setExecutor(new BookCommand());
        Objects.requireNonNull(this.getCommand("spawn")).setExecutor(new SpawnCommand());
        Objects.requireNonNull(this.getCommand("groups")).setExecutor(new GroupsCommand(this));

        // registering listeners.
        boolean placeMessage = getConfig().getBoolean("Listeners.PlaceMessage");
        if (placeMessage) {
            Bukkit.getPluginManager().registerEvents(new BlockPlaceEventListener(), this);
        }
        boolean breakMessage = getConfig().getBoolean("Listeners.BreakMessage");
        if (breakMessage) {
            Bukkit.getPluginManager().registerEvents(new BlockBreakEventListener(), this);
        }
        Bukkit.getPluginManager().registerEvents(new PlayerJoinEventListener(), this);
        setupPermissions();

        // Loaded message.
        getLogger().info("Successfully loaded HeckersPlugin!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye!");
    }


    private boolean setupPermissions() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            getLogger().warning(" - Disabled because Vault is not installed!");
            getServer().getPluginManager().disablePlugin(this);
            return false;
        }
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        if (rsp == null) {
            return false;
        }
        perms = rsp.getProvider();
        return perms != null;
    }

    public Permission getPermissions() {
        return perms;
    }
}
