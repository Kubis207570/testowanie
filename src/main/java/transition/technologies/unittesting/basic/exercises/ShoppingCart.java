/**
 * This example is based on example from the book:
 *
 * Pragmatic Unit Testing in Java with JUnit by:
 *  Andy Hunt
 *  Dave Thomas
 *
 *  All rights belong to the authors of the book.
 */
package transition.technologies.unittesting.basic.exercises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {

    private List<Item> itemList = new ArrayList<Item>();

    /**
     * Add this many of this item to the shopping cart.
     */
    public void addItems(Item anItem, int quantity)
            throws NegativeCountException {
        if (quantity >= 0) {
            for (int i = 0; i < quantity; i++) {
                itemList.add(anItem);
            }
        } else {
            throw new NegativeCountException();
        }
    }

    /**
     * Delete this many of this item from the shopping cart
     */
    public void deleteItems(Item anItem, int quantity)
            throws NegativeCountException, NoSuchItemException {
        if (quantity >= 0) {
            for (int i = 0; i < quantity; i++) {
                if (!itemList.contains(anItem)) {
                    throw new NoSuchItemException();
                }
                itemList.remove(anItem);
            }
        } else {
            throw new NegativeCountException();
        }
    }

    /**
     * Count of all items in the cart (that is, all items x qty each)
     */
    public int itemCount() {
        return itemList.size();
    }

    /**
     * Return Iterator of all items (see Java Collections doc)
     */
    public Iterator iterator() {
        return itemList.iterator();
    }
}
