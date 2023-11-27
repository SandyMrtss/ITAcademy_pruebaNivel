package pruebanivel;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import org.javatuples.Pair;

import static pruebanivel.GetInput.*;

public class TransactionsManager {
    private static final String currDir = System.getProperty("user.dir");
    private static final String vendorPath = currDir + "/src/main/pruebanivel/vendors.csv";
    private static final String itemPath = currDir + "/src/main/pruebanivel/items.csv";

    private static List<Npc> vendors;
    private static void createVendors(){
        File vendorData = new File(vendorPath);
        System.out.println("Creating predetermined vendors...");
        try {
            Scanner vendorScanner = new Scanner(vendorData);
            vendorScanner.nextLine();
            while(vendorScanner.hasNextLine()){
                String[] lineSplit = vendorScanner.nextLine().trim().split(",");
                String type = lineSplit[0];
                String city = lineSplit[1];
                if(type.equalsIgnoreCase("farmer")){
                    vendors.add(new Farmer(city));
                }
                else if(type.equalsIgnoreCase("merchant")) {
                    vendors.add(new Merchant(city));
                }
                else if(type.equalsIgnoreCase("thief")){
                    vendors.add(new Thief(city));
                }
            }
            System.out.println("Predetermined vendors created successfully");
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't find vendor data document");
        }
    }
    private static void createItems(){
        File itemData = new File(itemPath);
        System.out.println("Creating predetermined items...");
        try {
            Scanner itemScanner = new Scanner(itemData);
            itemScanner.nextLine();
            while(itemScanner.hasNextLine()){
                String[] lineSplit = itemScanner.nextLine().trim().split(",");
                String type = lineSplit[0];
                String name = lineSplit[1];
                double price = Double.parseDouble(lineSplit[2]);
                int idVendor = Integer.parseInt(lineSplit[3]);
                vendors.stream()
                        .filter(v -> v.getIdNpc() == idVendor)
                        .forEach(v -> {
                            try {
                                v.addItem(new Item(name, type, price));
                            } catch (FullInventoryException ex) {
                                System.out.println(ex.getMessage());;
                            }
                        });
            }
            System.out.println("Predetermined items added to vendors successfully");
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't find item data document");
        }
    }
    public static void loadData(){
        vendors = new ArrayList<>();
        System.out.println("----------------------------------------");
        System.out.println("Loading predetermined data...");
        createVendors();
        createItems();
        System.out.println("Predetermined data loaded successfully");
        System.out.println("----------------------------------------");
    }
    public static void showVendors(){
        System.out.println("List of vendors");
        System.out.println("----------------------------------------");
        vendors
                .forEach(System.out::println);
        System.out.println("----------------------------------------");
    }
    public static void showAllItems(){
        System.out.println("List of available items");
        System.out.println("----------------------------------------");
        vendors
                .forEach(v -> v.getInventory()
                        .forEach(System.out::println));
        System.out.println("----------------------------------------");
    }
    private static Npc findVendor(int id){
        Npc vendor = vendors.stream()
                .filter(v-> v.getIdNpc() == id)
                .findAny()
                .orElse(null);
        return vendor;
    }
    public static void showVendorInventory(int id){
        Npc vendor = findVendor(id);
        if (vendor == null){
            System.out.printf("No NPC found with ID %d", id);
            System.out.println();
        }
        else {
            vendor.showInventory();
        }
    }
    private static List<Npc> findVendorsCity(String city){
        ArrayList<Npc> cityVendors = new ArrayList<>();
        vendors.stream()
                .filter(v -> v.getCity().equalsIgnoreCase(city))
                .forEach(cityVendors::add);
        return cityVendors;
    }
    public static void printVendorsCity(String city){
        List<Npc> cityVendors = findVendorsCity(city);
        cityVendors.forEach(System.out::println);
    }
    public static void printCheapestItemAllVendors(){
        vendors
                .forEach(v->{
                    System.out.printf("NPC %d cheapest item: ", v.getIdNpc());
                    System.out.println(v.cheapestItem());
                        });
    }
    public static void printItemsType(String type){
        ArrayList<Item> itemsType = new ArrayList<>();
        vendors
                .forEach(v-> {
                    v.getInventory().stream()
                            .filter(i -> i.getType().equalsIgnoreCase(type))
                            .forEachOrdered(itemsType::add);
                });
        System.out.println(itemsType);
    }
    private static Map<Npc,Item> findItem(int idItem){
        Map<Npc, Item> npcItemMap = new HashMap<>();
        vendors.stream()
                .filter(v-> {
                    v.getInventory().stream()
                            .filter(i-> i.getIdItem() == idItem)
                            .forEach(i-> npcItemMap.put(v, i));
                });
        return item;
    }

    public static void buyItem(int idItem){
        AtomicBoolean itemDeleted = new AtomicBoolean(false);
         vendors
                .forEach(v-> {
                    v.getInventory().stream()
                            .filter(i -> i.getIdItem() == idItem)
                            .findAny()
                            .ifPresent(i-> {
                                itemDeleted.set(true);
                                v.deleteItem(i);
                                System.out.printf("Item %d bought successfully from vendor %d", i.getIdItem(), v.getIdNpc());
                                System.out.println();
                            });

                });
        if(!itemDeleted.get()){
            System.out.printf("Item %d not found", idItem);
            System.out.println();
        }
    }
    private static Item createUserItem(){
        String name = readString("What's the item's name?");
        String type = readString("What's the item's type?");
        double price = readDouble("What's the item's price?");
        return new Item(name, type, price);
    }
    public static void sellItem(){
        Item item = createUserItem();
        System.out.println("Which vendor do you want to sell it to?");
        showVendors();
        int vendorId = readInt("Id: ");
        Npc vendor = findVendor(vendorId);
        if (vendor == null){
            System.out.printf("No NPC found with ID %d", vendorId);
            System.out.println();
        }
        else {
            try {
                vendor.addItem(item);
            } catch (FullInventoryException ex) {
                ex.getMessage();
            }
        }
    }

}

