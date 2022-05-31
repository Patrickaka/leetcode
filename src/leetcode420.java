class Solution420 {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        int num = 0, lowerLetter = 0, upperLetter = 0;
        for (int i = 0; i < n; i++) {
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                num = 1;
            } else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                lowerLetter = 1;
            } else if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                upperLetter = 1;
            }
        }
        int kind = num + lowerLetter + upperLetter;
        if (n < 6) {
            return Math.max(6 - n, 3 - kind);
        } else if (n <= 20) {
            int t = 0;
            for (int i = 0; i < n; ) {
                int j = i;
                while (j < n && password.charAt(j) == password.charAt(i)) {
                    j++;
                }
                int cnt = j - i;
                if (cnt >= 3) {
                    t += cnt / 3;
                }
                i = j;
            }
            return Math.max(t, 3 - kind);
        } else {
            int t = 0;
            int[] cnts = new int[3];
            for (int i = 0; i < n; ) {
                int j = i;
                while (j < n && password.charAt(j) == password.charAt(i)) {
                    j++;
                }
                int cnt = j - i;
                if (cnt >= 3) {
                    t += cnt / 3;
                    cnts[t % 3]++;
                }
                i = j;
            }
            int base = n - 20, cur = base;
            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    cnts[i] = t;
                }
                if (cnts[i] != 0 && cur != 0) {
                    int t1 = Math.min(cnts[i] * (i + 1), cur);
                    cur -= t1;
                    t -= t1 / (i + 1);
                }
            }
            return base + Math.max(t, 3 - kind);
        }
    }
}