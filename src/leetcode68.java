import java.util.ArrayList;
import java.util.List;

class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ) {
            list.clear();
            list.add(words[i]);
            int cur = words[i++].length();
            while (i < n && cur + 1 + words[i].length() < maxWidth) {
                cur += 1 + words[i].length();
                list.add(words[i++]);
            }
            //最后一行
            if (i == n) {
                StringBuilder sb = new StringBuilder(list.get(0));
                for (int k = 1; k < list.size(); k++) {
                    sb.append(" ").append(list.get(k));
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
                ans.add(sb.toString());
                break;
            }
            //只有一个单词
            if (list.size() == 1) {
                StringBuilder str = new StringBuilder(list.get(0));
                while (str.length() < maxWidth) {
                    str.append(" ");
                }
                ans.add(str.toString());
                continue;
            }
            //一般情况
            int cnt = list.size();
            int wordWidth = cur - (cnt - 1);
            int spaceWidth = maxWidth - wordWidth;
            int spaceItemWidth = spaceWidth / (cnt - 1);
            StringBuilder spaceItemBuilder = new StringBuilder(" ");
            for (int k = 0; k < spaceItemWidth; k++) {
                spaceItemBuilder.append(" ");
            }
            String spaceItem = spaceItemBuilder.toString();
            StringBuilder sb = new StringBuilder();
            for (int k = 0, sum = 0; k < cnt; k++) {
                String item = list.get(k);
                sb.append(item);
                if (k == cnt - 1) {
                    break;
                }
                sb.append(spaceItem);
                sum += spaceItemWidth;
                int remain = cnt - k - 1 - 1;
                if (remain * spaceItemWidth + sum < spaceWidth) {
                    sb.append(" ");
                    sum++;
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}