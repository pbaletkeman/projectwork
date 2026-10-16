package try1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackPerumate {

    private void backTrack(List<String> result, String s, boolean[] used, String path) {
        if (path.length() == s.length()) {
            result.add(path);
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
            path = path + s.charAt(i);

            backTrack(result, s, used, path);

            path = path.substring(0, path.length() - 1);

            used[i] = false;
        }
    }

    public List<String> perumate(String word) {
        List<String> results = new ArrayList<>();
        boolean[] used = new boolean[word.length()];
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        backTrack(results, new String(chars), used, "");
        return results;
    }

    static void main() {
        BackTrackPerumate backTrack = new BackTrackPerumate();
        System.out.println(backTrack.perumate("pete"));
    }
}
