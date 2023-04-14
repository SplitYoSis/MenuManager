package dev.splityosis.menubuilder;

import dev.splityosis.menubuilder.items.MenuItem;
import dev.splityosis.menubuilder.menus.AbstractMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class MenuManager implements Listener {

    public static void setup(JavaPlugin plugin){
        plugin.getServer().getPluginManager().registerEvents(new MenuManager(), plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if (e.getClickedInventory() == null) return;
        if (e.getClickedInventory().getHolder() == null) return;
        if (!(e.getInventory().getHolder() instanceof AbstractMenu)) return;
        e.setCancelled(true);
        if (!(e.getClickedInventory().getHolder() instanceof AbstractMenu)) return;
        AbstractMenu menu = (AbstractMenu) e.getClickedInventory().getHolder();
        ItemStack clicked = e.getCurrentItem();
        if (clicked == null) return;
        MenuItem menuItem = menu.getItem(e.getSlot());
        if (menuItem == null) return;

        if (e.getClick() == ClickType.LEFT || e.getClick() == ClickType.SHIFT_LEFT)
            menuItem.onLeftClick(e, menu);
        else if (e.getClick() == ClickType.RIGHT || e.getClick() == ClickType.SHIFT_RIGHT)
            menuItem.onRightClick(e, menu);
    }

    @EventHandler
    public void onDrag(InventoryDragEvent e){
        if (!(e.getInventory().getHolder() instanceof AbstractMenu)) return;
        e.setCancelled(true);
    }
}