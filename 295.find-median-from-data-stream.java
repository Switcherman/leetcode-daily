/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 *
 * https://leetcode-cn.com/problems/find-median-from-data-stream/description/
 *
 * algorithms
 * Hard (31.53%)
 * Total Accepted:    1.1K
 * Total Submissions: 3.4K
 * Testcase Example:  '["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]\n[[],[1],[2],[],[3],[]]'
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 
 * 例如，
 * 
 * [2,3,4] 的中位数是 3
 * 
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 
 * 设计一个支持以下两种操作的数据结构：
 * 
 * 
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 
 * 
 * 示例：
 * 
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 
 * 进阶:
 * 
 * 
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 
 * 
 */
/**
 * 使用一个大顶堆和一个小顶堆存储数据.
 * 大顶堆中所有的数据小于小顶堆的数据.
 */
class MedianFinder {

    int count = 0;
    private PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    private PriorityQueue<Integer> maxQueue = new PriorityQueue<>(16, new Comparator<Integer>(){
        @Override
        public int compare(Integer i1, Integer i2) {
            return i2 - i1;
        }
    });

    /** initialize your data structure here. */
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        if ((count & 1) == 0) {// 偶数个数据进入小顶堆
            maxQueue.offer(num);
            num = maxQueue.poll();
            minQueue.offer(num);
        } else {
            minQueue.offer(num);
            num = minQueue.poll();
            maxQueue.offer(num);
        }
        count++;
    }
    
    public double findMedian() {
        if ((count & 1) != 0) {
            return new Double(minQueue.peek());
        } else {
            return new Double(minQueue.peek() + maxQueue.peek()) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
