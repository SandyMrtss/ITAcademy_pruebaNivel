package pruebanivel;

import java.util.*;

public abstract class Npc{
    protected String city;
    protected List<Item> inventory;
    protected static int idNpc = 0;

    public Npc(String city) {
        idNpc++;
        this.city = city;
        this.inventory = new ArrayList<>();
    }

    public abstract int getIdNpc();

    public void showInventory(){
        System.out.printf("Let's check NPC %d inventory", getIdNpc());
        System.out.println();
        if (inventory.isEmpty()){
            System.out.println("No items in this NPC");
        }
        inventory
                .forEach(System.out::println);
    }
    public Item cheapestItem(){
        Item cheapestItem = inventory.stream().min(Item::compareTo).get();
        return cheapestItem;
    }
    public abstract void addItem(Item item) throws FullInventoryException;
    public abstract void deleteItem(Item item);

    public List<Item> getInventory() {
        return inventory;
    }

    public String getCity(){
        return city;
    }
}
