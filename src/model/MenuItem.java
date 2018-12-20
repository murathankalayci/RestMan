package model;

public abstract class MenuItem {
    private String name;
    private double price;
    protected boolean isAvailable;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }

    public abstract boolean isAvailable();

    public String toString() {
        return name;
    }

}
