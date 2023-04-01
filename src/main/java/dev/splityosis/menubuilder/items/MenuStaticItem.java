package dev.splityosis.menubuilder.items;

import dev.splityosis.menubuilder.menus.AbstractMenu;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public abstract class MenuStaticItem extends MenuItem{
    @Override
    public abstract ItemStack getItem();

    @Override
    public void onLeftClick(InventoryClickEvent e, AbstractMenu menu) {

    }

    @Override
    public void onRightClick(InventoryClickEvent e, AbstractMenu menu) {

    }
}
