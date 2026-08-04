class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        for(int i = 0; i < points.length; i++)
        {
            int x = points[i][0];
            int y = points[i][1];
            int distance = x*x + y*y;

            maxHeap.offer(new int[]{distance, x, y});
            if(maxHeap.size() > k)
            {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++)
        {
            int[] coordinate = maxHeap.poll();
            res[i] = new int[]{coordinate[1], coordinate[2]};
        }
        return res;
    }
}
// k = 2
// points = [[0,1], [1,3], [0,2], [2,2]]
//             2      5     3      4
// maxheap = 
//             [3],[0,2]
//         [2], [0,1]






// //O(nlogn) time and O(n) space ~ suboptimal
// distance = [2, 5, 3, 4] => [2,3,4,5]
// hm = {
//     ([0,1], 2) => (2, [0,1]) //key = distance & value = coordinates
//     ([1,3], 5)
//     ([0,2], 3)
//     ([2,2], 4)
// }

// res[][] = [[0,1], [0,2]]