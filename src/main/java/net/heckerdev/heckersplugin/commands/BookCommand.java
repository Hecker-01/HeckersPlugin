package net.heckerdev.heckersplugin.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.jetbrains.annotations.NotNull;

public class BookCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("testplugin.command.book")) {

                // Create a new ItemStack (type: diamond)
                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bookMeta = (BookMeta) book.getItemMeta();

                BaseComponent[] page0 = new ComponentBuilder("Get 1 Diamond and 20 Bricks!").color(ChatColor.DARK_AQUA).bold(false).underlined(true)
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/kit kit"))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Execute /kit kit.").create()))
                        .append(", ").color(ChatColor.RESET)
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ""))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
                        .append("Get 1 Oak Plank.").color(ChatColor.DARK_AQUA).bold(false).underlined(true)
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/kit wood"))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Execute /kit wood.").create()))
                        .append(" OR ").color(ChatColor.RESET).bold(true).underlined(false)
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ""))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
                        .append("Get this book (again).").color(ChatColor.DARK_AQUA).bold(false).underlined(true)
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/book"))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Execute /book.").create()))
                        .create();

                bookMeta.spigot().addPage(page0);
                bookMeta.setTitle("A very cool book!");
                bookMeta.setAuthor("Hecker_01");

                book.setItemMeta(bookMeta);

                player.getInventory().addItem(book);
                player.sendMessage(org.bukkit.ChatColor.GREEN + org.bukkit.ChatColor.BOLD.toString() + "✔" + org.bukkit.ChatColor.RESET + org.bukkit.ChatColor.GREEN + " Successfully received book!");
                return true;
            } else player.sendMessage(org.bukkit.ChatColor.RED + "⚠ You do not have permission to use this command!");
        } else {
            sender.sendMessage(org.bukkit.ChatColor.DARK_RED + "You can only execute this as a player!");
        }
        return true;
    }
}
