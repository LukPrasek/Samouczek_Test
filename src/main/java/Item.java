import java.util.Map;

public class Item implements Comparable<Item> {
    String name;
    Double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Item)) {
            return false;
        }

        Item item = (Item) other;

        if (Double.compare(item.price, price) != 0) {
            return false;
        }
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        return result;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Item other) {
        if (other == null) {
            return 1;
        }
        return this.getName().compareTo(other.getName());
    }
}
