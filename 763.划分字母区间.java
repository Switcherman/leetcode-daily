/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] arrs = new int[26];
        for (int i = 0; i < S.length(); i++) {
            arrs[S.charAt(i) - 'a'] = i;
        }
        int end = 0;
        int start = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++ ){
            end = Math.max(end, arrs[S.charAt(i) - 'a']);
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }
}
// @lc code=end

