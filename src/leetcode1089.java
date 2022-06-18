class Solution1089 {
    public void duplicateZeros(int[] arr) {
        int n = arr.length, i = 0, j = 0;
        while (j < n) {
            if (arr[i] == 0) {
                j++;
            }
            i++;
            j++;
        }
        i--;
        j--;
        while (i >= 0) {
            if (j < n) {
                arr[j] = arr[i];
            }
            if (arr[i] == 0 && --j >= 0) {
                arr[j] = 0;
            }
            i--;
            j--;
        }
    }
}