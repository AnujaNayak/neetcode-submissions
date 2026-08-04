class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++)
        {
            minHeap.offer(nums[i]);
            if(minHeap.size() > k)
            {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
// k = 2
// nums = [2,1,3,3,5]

// minHeap = 
// 2 -> 1 -> 1 -> 2 -> 3 -> 3
//     2    2 3  3 3  3 5  5
    