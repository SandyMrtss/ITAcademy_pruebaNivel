package pruebanivel;

public class Item {
    private String name;
    private String type;
    private double price;
    private double wearPercentage;

    public Item(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double getWearPercentage() {
        return wearPercentage;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWearPercentage(double wearPercentage) {
        this.wearPercentage = wearPercentage;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price + "€" +
                ", wearPercentage=" + wearPercentage*100 + "%%" +
                '}';
    }
}
