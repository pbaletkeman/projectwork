import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class BackTrack {
    public static void main(String[] args) {
        BackTrack bt = new BackTrack();

        System.out.println("--- Unique Permutations of \"pete\" ---");
        char[] chars = "pete".toCharArray();
        Arrays.sort(chars);
        List<String> result = bt.permute(new String(chars));
        System.out.println(result);
        System.out.println("Count: " + result.size());

        System.out.println("\n--- Next Permutation of [1,2,3] ---");
        int[] nums = {1, 2, 3};
        System.out.print(Arrays.toString(nums) + " -> ");
        bt.nextperm(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println("\n--- Next Permutation of [3,2,1] ---");
        int[] nums2 = {3, 2, 1};
        System.out.print(Arrays.toString(nums2) + " -> ");
        bt.nextperm(nums2);
        System.out.println(Arrays.toString(nums2));

        System.out.println("\n--- 3rd Permutation of 1,2,3,4 ---");
        System.out.println(bt.kperm(4, 3));

        System.out.println("\n--- 5th Permutation of 1,2,3 ---");
        System.out.println(bt.kperm(3, 5));
    }

    /**
     * Generates all unique permutations of the given string.
     * The input string should be sorted to ensure duplicates are handled correctly.
     *
     * @param s the string to permute (should be sorted for correct deduplication)
     * @return a list of all unique permutations
     */
    List<String> permute(String s) {
        List<String> res = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        backtrack(res, s.toCharArray(), used, new StringBuilder());
        return res;
    }

    /**
     * Recursive backtracking helper that builds permutations character by character.
     * Skips duplicate characters to avoid generating duplicate permutations.
     *
     * @param res   the list to collect completed permutations
     * @param chars the sorted character array to permute
     * @param used  tracks which characters have been used in the current path
     * @param path  the current permutation being built
     */
    void backtrack(List<String> res, char[] chars, boolean[] used, StringBuilder path) {
        if (path.length() == chars.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.append(chars[i]);

            backtrack(res, chars, used, path);

            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }

    /**
     * Transforms the array into its next lexicographic permutation in-place.
     * If the array is already the largest permutation, it wraps around to the smallest.
     *
     * @param nums the array to transform (modified in-place)
     */
    void nextperm(int[] nums){
        int n = nums.length;

        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        if (i >= 0){
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i,j);
        }
        reverse(nums, i + 1, n -1);
    }
    /**
     * Swaps two elements in the array.
     *
     * @param nums the array
     * @param a    index of the first element
     * @param b    index of the second element
     */
    void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    /**
     * Reverses a portion of the array in-place.
     *
     * @param nums  the array
     * @param left  the starting index (inclusive)
     * @param right the ending index (inclusive)
     */
    void reverse(int [] nums, int left, int right){
        while (left < right){
            swap(nums, left++, right--);
        }
    }

    /**
     * Finds the k-th permutation of numbers 1 through n using factorial number system.
     * Permutations are ordered lexicographically, starting from k=1.
     *
     * @param n the upper bound of numbers to permute (1 to n)
     * @param k the 1-based index of the permutation to retrieve
     * @return the k-th permutation as a string of digits
     */
    String kperm(int n, int k){
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            nums.add(i);
        }

        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        k--;

        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int idx = k / fact[i];
            sb.append(nums.get(idx));
            nums.remove(idx);
            k %= fact[i];
        }
        return sb.toString();
    }
}
