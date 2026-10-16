import java.util.Arrays;

public class NextP {

    static final void next(char[] items) {
        int n = items.length;

        int i = n - 2;
        while (i >= 0 && items[i] > items[i + 1]) {
            i--;
        }

        if (i >= 0) {

            int j = n - 1;
            while (items[j] <= items[i]) {
                j--;
            }
            swap(items, i, j);
        }

        reverse(items, i + 1, n - 1);
    }

    static final void swap(char[] items, int a, int b) {
        Character t = items[a];
        items[a] = items[b];
        items[b] = t;
    }

    static final void reverse(char[] items, int left, int right) {
        while (left < right) {
            swap(items, left++, right--);
        }
    }

    static final void next(int[] items) {
        int n = items.length;

        int i = n - 2;
        while (i >= 0 && items[i] > items[i + 1]) {
            i--;
        }

        if (i >= 0) {

            int j = n - 1;
            while (items[j] <= items[i]) {
                j--;
            }
            swap(items, i, j);
        }

        reverse(items, i + 1, n - 1);
    }

    static final void swap(int[] items, int a, int b) {
        int t = items[a];
        items[a] = items[b];
        items[b] = t;
    }

    static final void reverse(int[] items, int left, int right) {
        while (left < right) {
            swap(items, left++, right--);
        }
    }


    static void main() {
        char[] a = new char[] {'a','b','c'};
        NextP.next(a);
        System.out.println(Arrays.toString(a));
        int[] b = new int[] {1,2,3,4};
        NextP.next(b);
        System.out.println(Arrays.toString(b));
    }
}
