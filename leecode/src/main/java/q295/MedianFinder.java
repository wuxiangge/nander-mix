package q295;

import java.util.PriorityQueue;

/**
 * @author zhangnan
 * @date 2021/9/3
 */
public class MedianFinder {

    private PriorityQueue<Integer> large;

    private PriorityQueue<Integer> small;

    public MedianFinder() {
        // 小顶堆
        large = new PriorityQueue<>();

        small = new PriorityQueue<>((a, b) -> b - a);
    }


    public double findMedia() {
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        return (large.peek() + small.peek()) / 2.0;
    }


    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }
}
