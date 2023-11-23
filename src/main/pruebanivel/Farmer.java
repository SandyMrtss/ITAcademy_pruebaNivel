package pruebanivel;

public class Farmer extends Npc{
    private static final int MAX_ITEMS = 5;
    private static final double TAX =  0.02;
    private static final double WEAR_TEAR =  0.15;
    private final int idNpc;

    public Farmer(String city) {
        super(city);
        this.idNpc = Npc.idNpc;
    }

    @Override
    public String toString() {
        return "Vendor Type= farmer, ID= " + idNpc + ", City= " + city;
    }

    @Override
    public int getIdNpc() {
        return idNpc;
    }

    @Override
    public void addItem(Item item) throws FullInventoryException {
        if(inventory.size() >= MAX_ITEMS){
            throw new FullInventoryException();
        }
        item.setWearPercentage(WEAR_TEAR);
        item.setPrice(item.getPrice()+ item.getPrice()*TAX);
        inventory.add(item);
    }

    @Override
    public void deleteItem(Item item) throws ItemNotFoundException{
        if (inventory.remove(item)){
            System.out.printf("Item %s deleted from NPC %s", item, this);
            System.out.println();
        }
        else{
            throw new ItemNotFoundException();
        }
    }
}
