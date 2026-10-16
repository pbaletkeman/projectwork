import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracker {

    private void backTracker(List<String> results, String s, boolean[] used, String path) {
        if (path.length() == s.length()){
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

            path += s.charAt(i);

            backTracker(results, s, used, path);

            path = path.substring(0, path.length() -1);

            used[i] = false;
        }

    }

    public List<String> permutate(String word) {
        List<String> results = new ArrayList<>();
        boolean[] used_elements = new boolean[word.length()];
        char[] wordChars = word.toCharArray();
        Arrays.sort(wordChars);
        backTracker(results, new String(wordChars), used_elements, "");
        return results;
    }

    static void main() {
        BackTracker backTracker = new BackTracker();
        System.out.print(backTracker.permutate("pete"));
    }

}
