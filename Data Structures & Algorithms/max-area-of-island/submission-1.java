class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col)
    {
        int maxArea = 1;
        grid[row][col] = 0;
        Stack<int[]> stack = new Stack<>(); //s = [0,1] [2,2]
        stack.push(new int[]{row, col});
        
        while(!stack.isEmpty())
        {
            int[] temp = stack.pop();
            int r = temp[0];
            int c = temp[1];

            //left
            if(c - 1 >= 0 && grid[r][c - 1] == 1)
            {
                maxArea++;
                grid[r][c - 1] = 0;
                stack.push(new int[]{r, c-1});
            }
            //right
            if(c + 1 < grid[0].length && grid[r][c + 1] == 1)
            {
                maxArea++;
                grid[r][c + 1] = 0;
                stack.push(new int[]{r, c+1});
            }
            //bottom
            if(r + 1 < grid.length && grid[r+1][c] == 1)
            {
                maxArea++;
                grid[r + 1][c] = 0;
                stack.push(new int[]{r+1, c});
            }
            //up
            if(r - 1 >= 0 && grid[r-1][c] == 1)
            {
                maxArea++;
                grid[r - 1][c] = 0;
                stack.push(new int[]{r-1, c});
            }
        }
        return maxArea;

    }
}

// grid=[

//     [0,1,1,0,1],
//     [1,0,1,0,1],
//     [0,1,1,0,1],
//     [0,1,0,0,1]

// ]

