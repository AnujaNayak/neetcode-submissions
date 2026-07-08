class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lastCol = matrix[0].length - 1;
        int[] r = new int[2];
        int[] l = new int[2];
        for(int i = 0; i < matrix.length; i++)
        {
            if(target <= matrix[i][lastCol]){
                r = new int[]{i, lastCol}; //2, 3
                l = new int[]{i, 0};      //2, 0
                break;
            }
        }

        int row = l[0]; //2
        int lCol = l[1]; //0
        int rCol = r[1]; //3
        while(lCol <= rCol)
        {
            int m = lCol + (rCol - lCol)/2; //2
            if(matrix[row][m] == target) //
            {
                return true;
            }
            else if(target < matrix[row][m])
            {
                rCol = m - 1;
            }
            else{
                lCol = m + 1; //2
            }
        }
        return false;
    }
}

// (1,0) (1,3)