import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BackTrack {

    void back(List<String> results, String s, boolean[] used, String path) {
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
            back(results, s, used, path + s.charAt(i));
            used[i] = false;

        }
    }

    List<String> values(String word){
        List<String> results = new ArrayList<>();
        boolean[] used = new boolean[word.length()];
        char[] s = word.toCharArray();
        Arrays.sort(s);
        back(results, new String(s), used, "");
        return results;
    }

    public static void main(String[] arg) {
        BackTrack backtrack = new BackTrack();
        List<String> results = backtrack.values("pete");
        System.out.print(results);
    }

}
