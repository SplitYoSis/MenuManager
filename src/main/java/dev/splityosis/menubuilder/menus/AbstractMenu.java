package dev.splityosis.menubuilder.menus;

import dev.splityosis.menubuilder.items.MenuItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMenu implements InventoryHolder {

    private Inventory inv;
    private Map<Integer, MenuItem> items = new HashMap<>();

    public void setItem(int slot, MenuItem menuItem){
        items.put(slot, menuItem);
        if (inv != null){
            inv.setItem(slot, (menuItem != null) ? menuItem.getItem() : null);
        }
    }

    public MenuItem getItem(int slot){
        return items.get(slot);
    }

    public Map<Integer, MenuItem> getItems() {
        return items;
    }

    public void clearItems(){
        if (inv != null)
            inv.clear();
        items.clear();
    }

    public abstract String getTitle();

    public abstract int getInventorySize();

    public Inventory open(Player player){
        if (inv == null) {
            inv = Bukkit.createInventory(this, getInventorySize(), getTitle());
            for (int i = 0; i < inv.getSize(); i++) {
                MenuItem item = items.get(i);
                if (item != null)
                    inv.setItem(i, item.getItem());
            }
        }
        player.openInventory(inv);
        return inv;
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
