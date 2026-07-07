class Solution {
    Queue<int[]> q = new LinkedList<>();
    public int orangesRotting(int[][] grid) {
        int freshFruit = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    freshFruit++;
                }
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }

        int totalMin = 0;
        while(!q.isEmpty() && freshFruit > 0)
        {
            totalMin++; //1
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                if(rotFruit(grid, row + 1, col)){
                    freshFruit--;
                }
                if(rotFruit(grid, row - 1, col)){
                    freshFruit--;
                }
                if(rotFruit(grid, row, col + 1)){
                    freshFruit--;
                }
                if(rotFruit(grid, row, col - 1)){
                    freshFruit--;
                }
            }
        }
        if(freshFruit != 0){
            return -1;
        }
        else{
            return totalMin;
        }
    }

    public boolean rotFruit(int[][] grid, int row, int col)
    {
        // System.out.println("1st freshFruit: " + freshFruit);
        if(row < 0 || row == grid.length || col < 0 || col == grid[0].length
            || grid[row][col] != 1){
            return false;
        }
        else{
            q.add(new int[]{row, col});
            grid[row][col] = 2;
            return true;
            // System.out.println("2nd freshFruit: " + freshFruit);
        }
    }
}