/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList();
        if (s.length() == 0 || numRows == 1) {
            return s;
        }
        for(int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        boolean upToDown = true;
        int index = 0;
        for (char c : s.toCharArray()) {
            list.get(index).append(c);
            if (index == numRows - 1) {
                upToDown = false;
            } else if (index == 0) {
                upToDown = true;
            }
            index = upToDown ? index + 1 : index - 1;
        }
        StringBuilder result = new StringBuilder();
        list.forEach(sb -> result.append(sb.toString()));
        return result.toString();
    }
}
// @lc code=end

