package pruebanivel;

import static pruebanivel.TransactionsManager.*;
import static pruebanivel.GetInput.*;
public class Main {
    static void showMenu(){
        System.out.println("What do you want to do?\n" +
                "1.- Check a vendor's inventory\n" +
                "2.- Check which vendors are in a city\n" +
                "3.- Show the cheapest item for all vendors\n" +
                "4.- Show all items from a type in price's ascending order\n" +
                "5.- Buy an item from a vendor\n" +
                "6.- Sell an item to a vendor\n" +
                "7.- Serialize vendors' information in JSON file\n" +
                "0.- Exit");
    }
    public static void main(String[] args) {
        System.out.println("Welcome!");
        loadData();
        boolean isExit;
        do{
            showMenu();
            isExit = false;
            int option = readInt("Option: ");
            switch (option) {
                case 1:
                    System.out.println("Which vendor's inventory do you want to see?\n" +
                            "Please input their id");
                    showVendors();
                    int vendorId = readInt("Id: ");
                    showVendorInventory(vendorId);
                    break;
                case 2:
                    System.out.println("Which city's vendors do you want to see?");
                    String city = readString("City: ");
                    System.out.printf("Vendors in %s", city);
                    System.out.println();
                    printVendorsCity(city);
                    break;
                case 3:
                    printCheapestItemAllVendors();
                    break;
                case 4:
                    String type = readString("Item type: ");
                    printItemsType(type);
                    break;
                case 5:
                    System.out.println("Which item do you want to buy?");
                    showAllItems();
                    int idItem = readInt("Item ID: ");
                    deleteItem(idItem);
                    break;
                case 6:
                    System.out.println("What item do you want to buy?");
                    break;
                case 7:
                    break;
                default:
                    option = 0;
                    isExit = true;
            }
        }
        while(!isExit);
        System.out.println("Goodbye!");


    }
}
