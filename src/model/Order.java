package model;

import java.util.ArrayList;

public class Order {
    private ArrayList<MenuItem> items;

    public Order(ArrayList<MenuItem> orderList) {
        items = orderList;
    }

    public String toString() {
        String string = "";
        for(MenuItem item : items)
            string += item + "\n";
        return string;
    }
}
