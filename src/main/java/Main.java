public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        Item firstItem = new Item("toy", 211.1);
        Item secondItem = new Item("blocks", 11.1);
        Item thirdItem = new Item("blocks", 11.1);
        Item fourItem = new Item("bike", 1001);

        // item added

        Item fourthItem = new Item("item4", 15.5);
        Item fifthItem = new Item("item5", 20.0);
        Item sixthItem = new Item("item5", 20.0);

        basket.add(firstItem, 5);
        basket.add(secondItem, 2);
        basket.add(thirdItem);
        basket.add(fourItem);
        System.out.println("Before removal:" + "\n" + basket.toString());
        basket.remove(firstItem, 2);
        basket.remove(thirdItem);
        System.out.println("After removal" + "\n" + basket.toString());




    }
}
