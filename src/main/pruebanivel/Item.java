package pruebanivel;

public class Item implements Comparable<Item>{
    private final String name;
    private final String type;
    private double price;
    private double wearPercentage;
    private final int idItem;
    private static int idItemCount = 0;


    public Item(String name, String type, double price) {
        idItemCount++;
        this.name = name;
        this.type = type;
        this.price = price;
        this.idItem = idItemCount;
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
    public int getIdItem(){
        return idItem;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWearPercentage(double wearPercentage) {
        this.wearPercentage = wearPercentage;
    }

    @Override
    public String toString() {
        return String.format("ITEM ID %d [Type: %-8s Name: %-10s Price:%6.2f €  Durability: %6.2f%%]", idItem, type, name, price, 100 - wearPercentage*100);
    }

    @Override
    public int compareTo(Item it) {
        return (int)(this.price*100 - it.getPrice()*100);
    }
}
