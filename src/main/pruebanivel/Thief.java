package pruebanivel;

public class Thief extends Npc{
    private static final int MAX_ITEMS = 3;
    private static final double TAX =  0.0;
    private static final double WEAR_TEAR =  0.25;
    private final int idNpc;

    public Thief(String city) {
        super(city);
        this.idNpc = Npc.idNpc;
    }

    @Override
    public String toString() {
        return "Vendor Type= thief, ID= " + idNpc + ", City= " + city;
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
