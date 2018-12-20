package model;

import java.util.ArrayList;

public class CompositeMenuItem extends MenuItem {
    private ArrayList<MenuItem> items;

    public CompositeMenuItem(String name, double price) {
        super(name, price);
        super.isAvailable = isAvailable();
        items = new ArrayList<>();
    }

    public CompositeMenuItem(String name, double price, ArrayList<MenuItem> menuItems) {
        super(name, price);
        super.isAvailable = isAvailable();
        items = menuItems;
    }

    public void addElement(MenuItem item) {
        items.add(item);
    }

    public boolean isAvailable() {
        for(MenuItem element : items){
            if(!element.isAvailable)
                return false;
        }
        return true;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public String toString() {
        String string = "";
        for(MenuItem item : items)
            string += item + "\n";
        return string;
    }
}
