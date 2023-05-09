package dev.splityosis.menubuilder.items;

import dev.splityosis.menubuilder.menus.AbstractMenu;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public abstract class MenuItem {

    public abstract ItemStack getItem();
    public abstract void onLeftClick(InventoryClickEvent e, AbstractMenu menu);
    public abstract void onRightClick(InventoryClickEvent e, AbstractMenu menu);

}