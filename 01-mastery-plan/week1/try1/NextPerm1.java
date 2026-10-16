
final class NextPerm1 {

    void nextPerm(int[] nums) {
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

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    void nextPerm(char[] lets) {
        int n = lets.length;

        int i = n - 2;

        while (i >= 0 && lets[i] >= lets[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            while (lets[j] <= lets[i]) {
                j--;
            }
            swap(lets, i, j);
        }
        reverse(lets, i + 1, n - 1);
    }

    private static void swap(char[] lets, int a, int b) {
        char temp = lets[a];
        lets[a] = lets[b];
        lets[b] = temp;
    }

    private static void reverse(char[] lets, int left, int right) {
        while (left < right) {
            swap(lets, left++, right--);
        }
    }

    public static void main(String[] args) {
        NextPerm1 nextPerm = new NextPerm1();
        char[] a = "cba".toCharArray();   // last permutation → wraps to "abc"
        nextPerm.nextPerm(a);
        System.out.println(new String(a)); // expect: abc

        int[] b = {1, 2, 3};
        nextPerm.nextPerm(b);
        System.out.println(java.util.Arrays.toString(b)); // expect: [1, 3, 2]

        char[] c = "abc".toCharArray();   // already last → stays "abc"
        nextPerm.nextPerm(c);
        System.out.println(new String(c)); // expect: acb
    }

}
