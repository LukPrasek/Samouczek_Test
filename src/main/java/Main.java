public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        Item firstItem = new Item("toy", 211.1);
        Item secondItem = new Item("blocks", 11.1);
        Item thirdItem = new Item("blocks", 11.1);

        basket.add(firstItem, 5);
        basket.add(secondItem, 2);
        basket.add(thirdItem);
        System.out.println("Before removal:" + "\n" + basket.toString());
        basket.remove(firstItem, 2);
        basket.remove(thirdItem);
        System.out.println("After removal" + "\n" + basket.toString());
    }
}
