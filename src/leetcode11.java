class Solution11 {
    public static int maxArea(int[] height) {
        int length = height.length;
        int max = 0,maxy = 0;
        for (int i = 0; i < length - 1; i++) {
            if(height[i] < maxy){
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                int x = j - i;
                int y = Math.min(height[i], height[j]);
                int area = x * y;
                if(area > max){
                    maxy = height[i];
                    max = area;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int ans = maxArea(height);
        System.out.println(ans);
    }
}