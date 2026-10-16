import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class back {
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

    List<String> permutation(String s){
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        backtrack(result, s.toCharArray(), used, new StringBuilder());
        return result;
    }

    void backtrack(List<String> result, char[] chars, boolean[] used, StringBuilder path){
        if (path.length() == chars.length){
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++){
            if (used[i]) {
                continue;
            }
            // handle dups
            if (i > 0 && chars[i] == chars[i - 1] && !used[i-1]){
                continue;
            }

            used[i] = true;
            path.append(chars[i]);

            backtrack(result, chars, used, path);
            path.deleteCharAt(path.length()-1);
            used[i] = false;
        }
    }

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
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }
    void swap(int [] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    void reverse(int[] nums, int left, int right){
        while (left < right){
            swap(nums, left++, right--);
        }
    }

    String kperm(int n, int k){
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            nums.add(i);
        }

        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++){
            fact[i] = fact[i - 1] * i;
        }
        k--;

        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--){
            int idx = k / fact[i];
            sb.append(nums.get(idx));
            nums.remove(idx);
            k %= fact[i];
        }
        return sb.toString();
    }
}
