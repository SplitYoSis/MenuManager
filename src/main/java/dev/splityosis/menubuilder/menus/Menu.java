package dev.splityosis.menubuilder.menus;

public class Menu extends AbstractMenu implements Cloneable{

    private AbstractMenu parent;
    private String title;
    private int inventorySize;

    public Menu(String title, int size) {
        this.title = title;
        this.inventorySize = size;
    }

    public void setParent(AbstractMenu parent) {
        this.parent = parent;
    }

    public AbstractMenu getParent() {
        return parent;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getInventorySize() {
        return inventorySize;
    }

    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }

    public Menu clone(){
        try {
            return (Menu) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}