package dev.splityosis.menubuilder.menus;

import dev.splityosis.menubuilder.items.MenuItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagedMenu extends Menu{

    private Map<Integer, MenuItem> staticItems = new HashMap<>();
    private List<MenuItem> listedItems = new ArrayList<>();
    private int currentPage = 0;

    public PagedMenu(String title, int inventorySize) {
        super(title, inventorySize);
    }

    public void addListedItem(MenuItem item){
        listedItems.add(item);
    }

    public void removeListedItem(MenuItem item){
        listedItems.remove(item);
    }

    public List<MenuItem> getListedItems() {
        return listedItems;
    }

    public void setListedItems(List<MenuItem> listedItems) {
        this.listedItems = listedItems;
    }

    public void replaceListedItem(MenuItem from, MenuItem to){
        listedItems.set(listedItems.indexOf(from),to);
    }

    public void setStaticItem(int slot, MenuItem menuItem){
        staticItems.put(slot, menuItem);
        setItem(slot, menuItem);
    }

    public void removeStaticItem(int slot){
        staticItems.remove(slot);
        setItem(slot, null);
    }

    public int getPagesAmount(){
        return listedItems.size()/getPageSize() + 1;
    }

    public int getPageSize(){
        return getInventorySize() - staticItems.size();
    }

    public boolean hasPage(int page){
        return page <= getPagesAmount() && page > 0;
    }

    public void setPage(int page){
        if (!hasPage(page)) return;
        currentPage = page;

        if (listedItems != null) {
            int itemIndex = (page-1)*getPageSize();
            for (int i = 0; i < getInventorySize(); i++) {
                if (staticItems.get(i) != null) continue;
                if (listedItems.size() > itemIndex){
                    setItem(i, listedItems.get(itemIndex));
                    itemIndex++;
                }
                else setItem(i, null);
            }
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    @Override
    public Inventory open(Player player) {
        if (currentPage == 0)
            setPage(1);
        return super.open(player);
    }

    public PagedMenu clone(){
        return (PagedMenu) super.clone();
    }
}