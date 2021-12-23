import java.util.ArrayList;
import java.util.List;

class Solution686 {
    public static int repeatedStringMatch(String a, String b) {
        int ans;
        List<Integer> list = new ArrayList<>();
        if (a.length() >= b.length() && a.contains(b)) {
            return 1;
        }
        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(0) == a.charAt(i)) {
                list.add(i);
            }
        }
        for (Integer integer : list) {
            ans = 0;
            int j = integer, isSame = 0;
            int lena = a.length();
            int lenb = b.length();
            int tempChar = 0;
            while (j < a.length()) {
                if (a.charAt(j) == b.charAt(tempChar)) {
                    j++;
                    tempChar++;
                    lenb--;
                } else {
                    isSame = 1;
                    break;
                }
            }
            if (isSame != 1) {
                ans++;
                while (lenb >= lena && b.substring(tempChar, tempChar + lena).contains(a)) {
                    lenb -= lena;
                    tempChar += lena;
                    ans++;
                    if (lenb == 0) {
                        return ans;
                    }
                }
                if (lenb >= lena) {
                    continue;
                }
                if (b.substring(tempChar).contains(a.substring(0, lenb)) && lenb > 0) {
                    ans++;
                    return ans;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "aa";
        int ans = repeatedStringMatch(a, b);
        System.out.println(ans);
    }
}