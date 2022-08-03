package meiri;

class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        char goal = (char) (target + 1);
        char ans = ' ';
        for (char c : letters) {
            if (c >= goal) {
                ans = c;
                break;
            }
        }
        if (ans == ' ') {
            ans = letters[0];
        }
        return ans;
    }
}