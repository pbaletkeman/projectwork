import java.util.Arrays;

class NextPerm {

    static void nextPerm(int[] nums) {
        int n = nums.length;

        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    static void nextPerm(char[] chr) {
        int n = chr.length;

        int i = n - 2;
        while (i > 0 && chr[i] >= chr[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            while (chr[j] <= chr[i]) {
                j--;
            }
            swap(chr, i, j);
        }
        reverse(chr, i + 1, n - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private static void swap(char[] chr, int a, int b) {
        char temp = chr[a];
        chr[a] = chr[b];
        chr[b] = temp;
    }

    private static void reverse(char[] chr, int left, int right) {
        while (left < right) {
            swap(chr, left++, right--);
        }
    }

    static void main() {
        int[] a = {1,2,3};
        System.out.println(Arrays.toString(a));
        NextPerm.nextPerm(a);
        System.out.println(Arrays.toString(a));
        char[] b = {'a','b','c'};
        System.out.println(Arrays.toString(b));
        NextPerm.nextPerm(b);
        System.out.println(Arrays.toString(b));
    }
}
