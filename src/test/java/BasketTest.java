import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class BasketTest {


    @Test
    public void shouldAllowToAddItemToBasket(){
        //given
        Basket basket = new Basket();
        Item item = new Item("toy", 39.99);

        Map<Item, Integer> expected = createOrder(toy, 1);
        assertEquals(expected, basket.getOrder());


    }

    private Map<Item,Integer> createOrder(Object...mapContent) {
        Map<Item,Integer> order=new HashMap<>();
        for(int i=0; i<mapContent.length;i+=2){
            Item item= (Item) mapContent[i];
            Integer quantity= (int) mapContent[i+1];
           order.put(item, quantity);
        }
        return order;
    }

    @Test
    public void remove() throws Exception {
    }

}