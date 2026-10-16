import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {

    void track(List<String> results, String s, boolean[] used, String path) {
        if (s.length() == path.length()) {
            results.add(path);
        }

        for (int i = 0; i < s.length(); i++) {

            if (used[i]) {
                continue;
            }

            if (i > 0 && s.charAt(i) == s.charAt(i - 1) && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            track(results, s, used, path + s.charAt(i));
            used[i] = false;
        }
    }

    List<String> values(String word) {
        List<String> results = new ArrayList<>();
        char[] chs = word.toCharArray();
        boolean[] used = new boolean[chs.length];
        Arrays.sort(chs);
        track(results, new String(chs), used, "");
        return results;
    }

    static void main() {
        Tracker tracker = new Tracker();
        System.out.println(tracker.values("pete"));
    }
}
