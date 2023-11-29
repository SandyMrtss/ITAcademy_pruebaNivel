package pruebanivel;


public class Main {
    private static void showMenu(){
        System.out.println("----------------------------------------");
        System.out.println("""
                What do you want to do?
                1.- Check a vendor's inventory
                2.- Check which vendors are in a city
                3.- Show the cheapest item for all vendors
                4.- Show all items from a type in price's ascending order
                5.- Buy an item from a vendor
                6.- Sell an item to a vendor
                7.- Serialize vendors' information in JSON file
                0.- Exit""");
        System.out.println("----------------------------------------");
    }
    public static void main(String[] args) {
        System.out.println("Welcome!");
        TransactionsManager.loadData();
        boolean isExit;
        do{
            showMenu();
            isExit = false;
            int option = GetInput.readInt("Option: ");
            switch (option) {
                case 1:
                    TransactionsManager.showVendorInventory();
                    break;
                case 2:
                    TransactionsManager.printVendorsCity();
                    break;
                case 3:
                    TransactionsManager.printCheapestItemAllVendors();
                    break;
                case 4:
                    TransactionsManager.printItemsType();
                    break;
                case 5:
                    TransactionsManager.buyItem();
                    break;
                case 6:
                    TransactionsManager.sellItem();
                    break;
                case 7:
                    TransactionsManager.serializeData();
                    break;
                default:
                    isExit = true;
            }
        }
        while(!isExit);
        System.out.println("Goodbye!");
    }
}
