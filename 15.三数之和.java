/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 特判
        if (nums == null || nums.length < 3) {
            return result;
        }
        // 排序
        Arrays.sort(nums);
        int n = nums.length;
        // 遍历排序后数组
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return result;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                // 令左指针l= i + 1; 右指针r=n-1,对于nums[i] + nums[l] + nums[r] == 0的,去掉重复解
                int temp = nums[i] + nums[l] + nums[r];
                if (temp == 0) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                // >0 r左移
                } else if (temp > 0) { 
                    r--;
                // <0 l右移
                } else {
                    l++;
                }
            }

        }
        return result;
    }
}
// @lc code=end

