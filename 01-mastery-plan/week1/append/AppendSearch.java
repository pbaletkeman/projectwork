import java.time.LocalDateTime;
import java.util.Arrays;


record Item(String itemId, String name, LocalDateTime createDateTime) {}

public class AppendSearch {

    public Item findFirstAfter(Item[] items, Item target) {
        int left = 0;
        int right = items.length;
        Item candidate = null;

        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;

            if (items[mid].createDateTime().isAfter(target.createDateTime())) {
                candidate = items[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return candidate;
    }

    public Item findLastBefore(Item[] items, Item target) {
        int left = 0;
        int right = items.length;
        Item candidate = null;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (items[mid].createDateTime().isBefore(target.createDateTime())) {
                candidate = items[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return  candidate;
    }

    public Item findItem(Item[] items, Item target) {
        int left = 0;
        int right = items.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (items[mid].createDateTime().isEqual(target.createDateTime())) {
                return items[mid];
            }

            if (items[mid].createDateTime().isBefore(target.createDateTime())) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public Item[] createSampleItems(int length) {
        Item[] retval = new Item[length];
        for (int i = 0; i < length; i++) {
            retval[i] = new Item(String.valueOf(i), "name-" + i, LocalDateTime.of(2026, 5, i+1, 2, 0));
        }
        return retval;
    }

    public static void main() {
        AppendSearch search = new AppendSearch();
        Item[] items = search.createSampleItems(10);
        System.out.println(Arrays.toString(items));
        Item target = new Item("4", "name-4", LocalDateTime.of(2026, 5, 5, 2, 0));

        Item exact = search.findItem(items, target);

        System.out.println("------------");
        System.out.println("Exact");
        System.out.println("------------");
        System.out.println("Target");
        System.out.println(target);
        System.out.println("Result");
        System.out.println(exact);
        System.out.println("------------");

        target = new Item("4", "name-4", LocalDateTime.of(2026, 5, 5, 12, 0));
        Item after = search.findFirstAfter(items, target);

        System.out.println("\n\n------------");
        System.out.println("After");
        System.out.println("------------");
        System.out.println("Target");
        System.out.println(target);
        System.out.println("Result");
        System.out.println(after);
        System.out.println("------------");

        target = new Item("2", "name-2", LocalDateTime.of(2026, 5, 2, 1, 0));
        Item before = search.findLastBefore(items, target);

        System.out.println("\n\n------------");
        System.out.println("Before");
        System.out.println("------------");
        System.out.println("Target");
        System.out.println(target);
        System.out.println("Result");
        System.out.println(before);
        System.out.println("------------");

    }
}
