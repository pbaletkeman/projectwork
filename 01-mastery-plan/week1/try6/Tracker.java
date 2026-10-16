import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Tracker {

    void track(List<String> results, String s, boolean[] used, String path) {
        if (s.length() == path.length()) {
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
            track(results, s, used, path + s.charAt(i));
            used[i] = false;
        }
    }

    List<String> values(String word) {
        List<String> results = new ArrayList<>();
        char[] s = word.toCharArray();
        Arrays.sort(s);
        boolean[] used = new boolean[s.length];
        track(results, new String(s), used, "");
        return results;
    }

    static void main() {
        Tracker t = new Tracker();
        System.out.println(t.values("pete"));
    }
}
