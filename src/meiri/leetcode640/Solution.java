package meiri.leetcode640;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveEquation("-x=-1"));
    }

    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        int[] x = new int[2], sum = new int[2];
        for (int k = 0; k < split.length; k++) {
            String str = split[k];
            int previdx = 0;
            char prevOp = equation.charAt(0) == '-' ? '-' : '+';
            int xsum = 0, sums = 0;
            for (int i = 0; i < str.length(); ) {
                if (str.charAt(i) == '-' && i == 0) {
                    i++;
                }
                if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                    String s = str.substring(previdx, i);
                    if (s.charAt(s.length() - 1) == 'x') {
                        String substring = s.substring(0, s.length() - 1);
                        if (prevOp == '+') {
                            if ("".equals(substring)) {
                                xsum++;
                            } else {
                                xsum += Integer.parseInt(substring);
                            }
                        } else {
                            if ("".equals(substring)) {
                                xsum--;
                            } else {
                                xsum -= Integer.parseInt(substring);
                            }
                        }

                    } else {
                        if (prevOp == '+') {
                            sums += Integer.parseInt(s);
                        } else {
                            sums -= Integer.parseInt(s);
                        }
                    }
                    previdx = i + 1;
                    prevOp = str.charAt(i);
                }
                i++;
            }
            String s = str.substring(previdx);
            if (s.charAt(s.length() - 1) == 'x') {
                String substring = s.substring(0, s.length() - 1);
                if (prevOp == '+') {
                    if ("".equals(substring)) {
                        xsum++;
                    } else {
                        xsum += Integer.parseInt(substring);
                    }
                } else {
                    if ("".equals(substring)) {
                        xsum--;
                    } else {
                        xsum -= Integer.parseInt(substring);
                    }
                }

            } else {
                if (prevOp == '+') {
                    sums += Integer.parseInt(s);
                } else {
                    sums -= Integer.parseInt(s);
                }
            }
            x[k] = xsum;
            sum[k] = sums;
        }
        int a = x[0] - x[1], b = sum[1] - sum[0];
        if (a == 0 && b == 0) {
            return "Infinite solutions";
        } else if (a == 0) {
            return "No solution";
        } else {
            return "x=" + b / a;
        }
    }

}