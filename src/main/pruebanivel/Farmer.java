package pruebanivel;

import java.util.ArrayList;
import java.util.List;

public class Farmer extends Npc{
    private String city;
    private final int MAX_ITEMS = 5;
    private final double TAX =  0.02;
    private final double WEAR_TEAR =  0.15;
    private List<Item> inventory;
    private final int idNpc;

    public Farmer(String city) {
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
    public String toString() {
        return "Vendor type= farmer, id= " + idNpc + ", city= " + city;
    }
}
