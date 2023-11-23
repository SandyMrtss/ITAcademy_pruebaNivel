package pruebanivel;

import java.util.List;

public abstract class Npc {
    private String city;
    private List<Item> inventory;
    private int MAX_ITEMS;
    private double TAX;
    private double WEAR_TEAR;
    public static int idNpc = 0;

    public Npc() {
        idNpc++;
    }

    public int getIdNpc() {
        return idNpc;
    }


    public void buyItem(Item item) throws FullInventoryException { //abstract
        if(inventory.size() >= MAX_ITEMS){
            throw new FullInventoryException();
        }
        item.setWearPercentage(this.WEAR_TEAR);
        item.setPrice(item.getPrice()+ item.getPrice()*this.TAX);
        inventory.add(item);
    }

    public void sellItem(Item item){ //abstract
        inventory.remove(item);
    }
    public void showInventory(){
        if (inventory.isEmpty()){
            System.out.println("No items in this NPC");
        }
        for(Item item : inventory){
            System.out.println(item);
        }
    }
    public Item cheapestItem(){
        double cheapest = Double.POSITIVE_INFINITY;
        Item cheapestItem = null;
        for (Item item: inventory){
            if(item.getPrice() < cheapest){
                cheapestItem = item;
            }
        }
        return cheapestItem;
    }


    public List<Item> getInventory() {
        return inventory;
    }

    public abstract String getCity();
}
