package sample.Model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.math.BigDecimal;

public class Menu extends RecursiveTreeObject<Menu> {
    private int menuItemId;
    private String menuItemName;
    private String menuItemDescription;
    private BigDecimal menuItemPrice;

    public Menu() {
    }

    public Menu(int menuItemId, String menuItemName, String menuItemDescription, BigDecimal menuItemPrice) {
        this.menuItemId = menuItemId;
        this.menuItemName = menuItemName;
        this.menuItemDescription = menuItemDescription;
        this.menuItemPrice = menuItemPrice;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public String getMenuItemDescription() {
        return menuItemDescription;
    }

    public void setMenuItemDescription(String menuItemDescription) {
        this.menuItemDescription = menuItemDescription;
    }

    public BigDecimal getMenuItemPrice() {
        return menuItemPrice;
    }

    public void setMenuItemPrice(BigDecimal menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
    }

    public String toString(){
        return menuItemName;
    }



}
