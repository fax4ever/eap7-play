package it.redhat.demo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 26/05/16
 */
public class Cart {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

}
