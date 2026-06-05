class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));
        for(int n : stones)
        {
            maxHeap.add(n);
        }

        while(maxHeap.size() > 1)
        {
            int subtraction = maxHeap.poll() - maxHeap.poll();
            // if(subtraction != 0)
            // {
            //     maxHeap.add(subtraction);
            // }
            maxHeap.add(subtraction);
        }
        return maxHeap.peek();
    }
}
