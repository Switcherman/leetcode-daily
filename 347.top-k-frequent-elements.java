/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前K个高频元素
 *
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (53.26%)
 * Total Accepted:    6.7K
 * Total Submissions: 12.6K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 
 * 说明：
 * 
 * 
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 
 * 
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>(16, (p1, p2) -> {
            return p2.count - p1.count;
        });
        map.forEach((num, count) -> {
            queue.offer(new Pair(num, count));
        });
        List<Integer> result = new ArrayList<>();
        while (k > 0) {
            result.add(queue.remove().num);
            k--;
        }
        return result;
    }
    /**
     * 数字计数器类
     */
    class Pair {
        Integer num;
        Integer count;
        Pair(Integer num, Integer count) {
            this.num = num;
            this.count = count;
        }
    }

}
