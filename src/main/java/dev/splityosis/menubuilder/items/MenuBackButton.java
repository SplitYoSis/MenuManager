package dev.splityosis.menubuilder.items;

import dev.splityosis.menubuilder.menus.AbstractMenu;
import dev.splityosis.menubuilder.menus.Menu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuBackButton extends MenuItem {

    private ItemStack item;

    public MenuBackButton(ItemStack item) {
        this.item = item;
    }

    public MenuBackButton() {}

    @Override
    public ItemStack getItem() {
        if (item != null) return item;
        ItemStack itemStack = new ItemStack(Material.BARRIER, 1);
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.RED + "Back");
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    @Override
    public void onLeftClick(InventoryClickEvent e, AbstractMenu menu) {
        if (menu instanceof Menu){
            if (((Menu) menu).getParent() != null)
                ((Menu) menu).getParent().open((Player) e.getWhoClicked());
        }
    }

    @Override
    public void onRightClick(InventoryClickEvent e, AbstractMenu menu) {
        onLeftClick(e, menu);
    }
}