package meiri;

class Solution1185 {

    static String[] weeks = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String dayOfTheWeek(int day, int month, int year) {
        int ans = 4;
        for (int i = 1971; i < year; i++) {
            boolean flag = (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
            ans += flag ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            ans += months[i - 1];
            if (i == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
                ans++;
            }
        }
        ans += day;
        return weeks[ans % 7];
    }
}