class Solution {
    Queue<int[]> q = new LinkedList<>();
    public void islandsAndTreasure(int[][] grid) {
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 0)
                {
                    q.add(new int[]{i,j});
                }
            }
        }
        
        int dist = 0;
        while(!q.isEmpty())
        {
            dist++;
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                addDistance(grid, row + 1, col, dist);
                addDistance(grid, row - 1, col, dist);
                addDistance(grid, row, col + 1, dist);
                addDistance(grid, row, col - 1, dist);
            }
        }
    }

    public void addDistance(int[][] grid, int row, int col, int dist)
    {
        if(row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] != 2147483647)
        {
            return;
        }
        else
        {
            q.add(new int[]{row, col});
            grid[row][col] = dist;
        }
    }
}


// [INF-1,  -1,   0,    INF],
// [INF-1,  INF, INF,   -1],
// [INF,  -1,  INF,   -1],
// [0,    -1,  INF,   INF]

// hm = ([0,0], 1) ([1,0], 1) ([1,1], 1)
// ([], )

// [1,0],1
// next =  
// distance += hs.get(1);

// // [0,0],[1]
