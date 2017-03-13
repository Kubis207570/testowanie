package transition.technologies.unittesting.basic.exercises;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author agnieszka
 */
public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    public ShoppingCartTest() {
    }

    @Before
    public void setUp() {
        shoppingCart = new ShoppingCart();

    }

    @Test
    public void shouldBeAddedItem() throws NegativeCountException {
        shoppingCart.addItems(new Item(), 20);
        assertEquals(shoppingCart.itemCount(), 20);
    }

        @Test
    public void shouldBeAddedCorrectItem() throws NegativeCountException {
        Item item = new Item();
        shoppingCart.addItems(item, 1);
        Item item2 =(Item) shoppingCart.iterator().next();
        assertEquals(item2.getName(), item.getName());
    }
    
    @Test
    public void shouldBeDeletedItem() throws NegativeCountException, NoSuchItemException {
        Item item = new Item();
        shoppingCart.addItems(item, 2);
        shoppingCart.deleteItems(item, 1);
        assertEquals(shoppingCart.itemCount(), 1);
    }

    @Test(expected = NegativeCountException.class)
    public void shouldBeNegativeCountException_quantityIsNegativeWhereAddMethod() throws NegativeCountException {
        shoppingCart.addItems(new Item(), -20);
    }

    @Test(expected = NegativeCountException.class)
    public void shouldBeNegativeCountException_quantityIsNegativeWhereDeleteMethod() throws NegativeCountException, NoSuchItemException {
        shoppingCart.deleteItems(new Item(), -20);
    }

    @Test(expected = NoSuchItemException.class)
    public void shouldBeNoSuchItemException_itemNotExistInList() throws NegativeCountException, NoSuchItemException {
        shoppingCart.deleteItems(new Item(), 1);
    }
}
