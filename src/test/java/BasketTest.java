import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class BasketTest {
    private static final double PRICE_DELTA = 0.001;

    private Basket basket;
    private Item item;

    @Before
    public void setUp() {
        item = new Item("toy", 39.99);
        basket = new Basket();
    }

    @Test
    public void shouldAllowToAddItemToBasket() {
        //given
        Map<Item, Integer> expected = createOrder(item, 1);

        //when
        basket.add(item);
        //then
        assertEquals(expected, basket.getOrder());
    }

    private Map<Item, Integer> createOrder(Object... mapContent) {
        Map<Item, Integer> order = new HashMap<>();
        for (int i = 0; i < mapContent.length; i += 2) {
            Item item = (Item) mapContent[i];
            Integer quantity = (int) mapContent[i + 1];
            order.put(item, quantity);
        }
        return order;
    }

    @Test
    public void shouldAllowToRemoveItemFromBasket() {
        //given

        Item item2 = new Item("doll", 11.99);

        Map<Item, Integer> expected = createOrder(item, 1);
        basket.add(item,1);
        basket.add(item2,1);

        //when
        basket.remove(item2);
        //then
        assertEquals(expected, basket.getOrder());
    }
    @Test
    public void shouldAllowToRemoveMultipleItemsFromBasket() {
        //given

        Item item2 = new Item("doll", 11.99);

        Map<Item, Integer> expected = createOrder(item, 1);
        basket.add(item,1);
        basket.add(item2,2);

        //when
        basket.remove(item2,2);
        //then
        assertEquals(expected, basket.getOrder());
    }
    @Test
    public void shouldCalculateOrderValueforOneItem() {
        //given
        double PRICE_DELTA = 0.001;
        Basket basket = new Basket();
        Item item = new Item("toy", 12);
       // Item item2 = new Item("doll", 11.99);

        Map<Item, Integer> expected = createOrder(item, 1);
        basket.add(item,3);
     double expectedValue= item.getPrice()*3;

        //when

        //then
        assertEquals(expectedValue, basket.getOrderValue(),PRICE_DELTA);
    }
    @Test
    public void shouldCalculateOrderValueForManyItems() {
        //given
        double PRICE_DELTA = 0.001;
        Basket basket = new Basket();
        Item item = new Item("toy", 12);
        Item item2 = new Item("doll", 15);
        // Item item2 = new Item("doll", 11.99);

        Map<Item, Integer> expected = createOrder(item, 1);
        basket.add(item,3);
        basket.add(item2,4);
        double expectedValue= item.getPrice()*3+item2.getPrice()*4;

        //when

        //then
        assertEquals(expectedValue, basket.getOrderValue(),PRICE_DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldTrowExcptionWhenRemovingNegativeQuantity() {

        basket.remove(item, -10);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenThereIsNoThatManyItemsToRemove() {
        basket.add(item,2);
        basket.remove(item,3);
    }
}