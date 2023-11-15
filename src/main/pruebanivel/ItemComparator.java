package pruebanivel;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return (int)(o1.getPrice() - o2.getPrice());
    }
}
