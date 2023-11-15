package pruebanivel;

import java.util.ArrayList;
import java.util.List;

public class Thief extends Npc{
    private String city;
    private final int MAX_ITEMS = 3;
    private final double TAX =  0.0;
    private final double WEAR_TEAR =  0.25;
    private List<Item> inventory;
    private final int idNpc;

    public Thief(String city) {
        super();
        this.city = city;
        this.inventory = new ArrayList<>(MAX_ITEMS);
        this.idNpc = Npc.idNpc;
    }
    @Override
    public String getCity() {
        return city;
    }
     @Override
    public void buyItem(Item item) {

    }

    @Override
    public void sellItem(Item item) {

    }


    @Override
    public String toString() {
        return "Vendor type= thief, id=" + idNpc + ", city= " + city;
    }
}
