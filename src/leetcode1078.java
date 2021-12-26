import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] ans = new String[110];
        String[] texts = text.split(" ");
        int temp = 0;
        int n = texts.length;

        for (int i = 0; i < n - 2; i++) {
            if (texts[i].equals(first) && texts[i + 1].equals(second)) {
                ans[temp++] = texts[i + 2];
            }
        }
        List<String> list = new ArrayList<>();
        for (String obj : ans) {
            if (Objects.nonNull(obj)) {
                list.add(obj);
            }
        }
        ans = list.toArray(new String[0]);
        return ans;
    }
}