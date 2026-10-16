package week1.try4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracker {

    void tracker(List<String> results, String s, boolean[] used, String path) {
        if (s.length() == path.length()){
            results.add(path);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && s.charAt(i) == s.charAt(i - 1) && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            tracker(results, s, used, path + s.charAt(i));
            used[i] = false;
        }
    }

    List<String> values(String word) {
        List<String> results = new ArrayList<>();
        boolean[] used = new boolean[word.length()];
        char[] s = word.toCharArray();
        Arrays.sort(s);
        tracker(results, new String(s), used, "");
        return results;
    }

    static void main() {
        BackTracker backTracker = new BackTracker();
        List<String> results = backTracker.values("pete");
        System.out.println(results);
    }
}
