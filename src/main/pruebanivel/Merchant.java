package pruebanivel;

public class Merchant extends Npc{
    private static final int MAX_ITEMS = 7;
    private static final double TAX =  0.04;
    private static final double WEAR_TEAR =  0.0;
    private final int idNpc;
    public Merchant(String city) {
        super(city);
        this.idNpc = Npc.idNpc;
    }


    @Override
    public String toString() {
        return "Vendor Type= merchant, ID= " + idNpc + ", City= " + city;
    }

    @Override
    public int getIdNpc() {
        return idNpc;
    }

    @Override
    public void addItem(Item item) throws FullInventoryException {
        if(this.inventory.size() >= MAX_ITEMS){
            throw new FullInventoryException();
        }
        item.setWearPercentage(WEAR_TEAR);
        item.setPrice(item.getPrice()+ item.getPrice()*TAX);
        this.inventory.add(item);
    }

    @Override
    public void deleteItem(Item item) throws ItemNotFoundException {
        if (this.inventory.remove(item)){
            System.out.printf("Item %s deleted from NPC %s", item, this);
            System.out.println();
        }
        else{
            throw new ItemNotFoundException();
        }
    }
}
