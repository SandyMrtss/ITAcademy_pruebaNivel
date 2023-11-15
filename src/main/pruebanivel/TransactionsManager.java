package pruebanivel;

import java.util.*;

public class TransactionsManager {
    private static List<Npc> vendors;
    static{
        System.out.println("Creating predetermined vendors...");
        vendors = new ArrayList<>();
        vendors.add(new Farmer("Madrid"));
        vendors.add(new Merchant("Barcelona"));
        vendors.add(new Thief("Barcelona"));
        System.out.println("Predetermined vendors created...");
        System.out.println("Creating predetermined items");
        try {
            vendors.get(0).buyItem(new Item("banana", "food", 1.7));
            vendors.get(0).buyItem(new Item("apple", "food", 1.2));
            vendors.get(1).buyItem(new Item("shirt", "clothes", 1.7));
            vendors.get(1).buyItem(new Item("sword", "weapon", 1.7));
            vendors.get(2).buyItem(new Item("necklace", "jewelry", 1.7));
            vendors.get(2).buyItem(new Item("jacket", "clothes", 1.7));

        } catch (FullInventoryException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Predetermined items created");

    }
    public static void showVendors(){
        for(Npc vendor: vendors) {
            System.out.println(vendor);
        }
    }
    public static void showItems(){
        for(Npc vendor: vendors) {
            for(Item item : vendor.getInventory()){
                System.out.println(item);
            }
        }
    }
    public static void showVendorInventory(int id){
        boolean isFound = false;
        for(Npc vendor: vendors){
            if(vendor.getIdNpc() == id){
                vendor.showInventory();
                isFound = true;
            }
        }
        if(!isFound){
            System.out.println("No vendor with chosen id found");
        }
    }
    public static List<Npc> findVendorsCity(String city){
        ArrayList<Npc> cityVendors = new ArrayList<>();
        vendors.stream()
                .filter(v -> v.getCity().equalsIgnoreCase(city))
                .forEach(cityVendors::add);
        return cityVendors;
    }

    public static void printCheapestItemAllVendors(List<Npc> cityVendors){
        for(Npc vendor : cityVendors){
            System.out.println(vendor.cheapestItem());
        }

    }
    public static void printItemsType(String type){
        ArrayList<Item> itemsType = new ArrayList<>();
        for(Npc vendor : vendors){
            vendor.getInventory().stream()
                    .filter(item -> item.getType().equalsIgnoreCase(type))
                    .forEach(itemsType::add);
        }
        itemsType.sort(new ItemComparator());
        System.out.println(itemsType);
    }
    public static boolean deleteItem(String name){
        for(Npc vendor: vendors) {
            for(Item item : vendor.getInventory()){
                if(item.getName().equalsIgnoreCase(name)){
                    vendor.sellItem(item);
                    return true;
                }
            }
        }
        return false;
    }
}
