package dev.splityosis.menubuilder.items;

import dev.splityosis.menubuilder.menus.AbstractMenu;
import dev.splityosis.menubuilder.menus.PagedMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuLastPageButton extends MenuItem{

    @Override
    public ItemStack getItem() {
        ItemStack itemStack = new ItemStack(Material.ARROW, 1);
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.GREEN + "Last page");
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    @Override
    public void onLeftClick(InventoryClickEvent e, AbstractMenu menu) {
        if (menu instanceof PagedMenu){
            PagedMenu pagedMenu = (PagedMenu) menu;
            if (pagedMenu.hasPage(pagedMenu.getCurrentPage()-1))
                pagedMenu.setPage(pagedMenu.getCurrentPage()-1);
        }
    }

    @Override
    public void onRightClick(InventoryClickEvent e, AbstractMenu menu) {
        onLeftClick(e, menu);
    }
}
