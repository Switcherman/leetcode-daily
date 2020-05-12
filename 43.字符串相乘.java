/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] sum = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int total = n1 * n2 + sum[i + j + 1];
                sum[i + j] += total / 10;
                sum[i + j + 1] = total % 10;
            }
            
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sum.length; i++) {
            if (i == 0 && sum[i] == 0) {
                continue;
            }
            sb.append(sum[i]);
        }
        return sb.toString();
    }
}
// @lc code=end

