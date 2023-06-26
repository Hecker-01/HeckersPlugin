package net.heckerdev.testplugin;

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

import static org.bukkit.Bukkit.getLogger;

public class CommandBook implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Create a new ItemStack (type: diamond)
            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta bookMeta = (BookMeta) book.getItemMeta();

            BaseComponent[] page0 = new ComponentBuilder("Get 1 diamond and 20 bricks!").color(ChatColor.BLUE).bold(false).underlined(true)
                    .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/kit"))
                    .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Execute /kit.").create()))
                    .append(" OR ").color(ChatColor.DARK_RED).bold(true).underlined(false)
                    .append("Get this book (again).").color(ChatColor.BLUE).bold(false).underlined(true)
                    .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/book"))
                    .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Execute /book.").create()))
                    .create();

            bookMeta.spigot().addPage(page0);
            bookMeta.setTitle("A very cool book!");
            bookMeta.setAuthor("Amogus Bobby");

            book.setItemMeta(bookMeta);

            player.getInventory().addItem(book);
        } else getLogger().warning("You can only execute this as a player!");

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
