import org.jetbrains.annotations.NotNull;

class Solution1154 {
    public static int dayOfYear(@NotNull String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        boolean flag = false;
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                flag = true;
            }
        } else {
            if (year % 4 == 0 && year % 100 != 0) {
                flag = true;
            }
        }
        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ans = 0;
        for (int i = 1; i <= month; i++) {
            ans += monthDays[i - 1];
        }
        if (flag && month > 2) {
            ans++;
        }
        ans += day;
        return ans;
    }

    public static void main(String[] args) {
        String date = "2019-01-10";
        int ans = dayOfYear(date);
        System.out.println(ans);
    }
}