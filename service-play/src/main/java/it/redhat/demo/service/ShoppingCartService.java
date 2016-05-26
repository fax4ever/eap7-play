package it.redhat.demo.service;

import it.redhat.demo.model.Cart;
import it.redhat.demo.model.Item;
import org.infinispan.Cache;

import javax.ejb.Stateless;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 26/05/16
 */
@Stateless
public class ShoppingCartService {

    private Cache<String, Cart> cache;

    public void addFirstItem(String sessionId, String itemName, String itemCode) {

        Cart cart = new Cart();
        Item item = new Item(itemName, itemCode);
        cart.addItem(item);
        cache.put(sessionId, cart);

    }


}
