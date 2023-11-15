package pruebanivel;

import java.util.ArrayList;
import java.util.List;

public class Merchant extends Npc{
    private String city;

    private final int MAX_ITEMS = 7;
    private final double TAX =  0.04;
    private final double WEAR_TEAR =  0.0;
    private List<Item> inventory;
    private final int idNpc;
    public Merchant(String city) {
        super();
        this.city = city;
        this.inventory = new ArrayList<>(MAX_ITEMS);
        this.idNpc = Npc.idNpc;
    }


    @Override
    public void buyItem(Item item) {

    }
    @Override
    public String getCity() {
        return city;
    }
    @Override
    public void sellItem(Item item) {

    }

    @Override
    public String toString() {
        return "Vendor type= merchant, id= " + idNpc + ", city= " + city;
    }
}
