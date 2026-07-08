class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0;
        int r = row - 1;
        int[] left = new int[2];
        int[] right = new int[2];
        while(l <= r)
        {
            int m = l + (r-l)/2;
            if(target >= matrix[m][0] && target <= matrix[m][col - 1])
            {
                left = new int[]{m, 0};
                right = new int[]{m, col - 1};
                break;
            }
            else if(target > matrix[m][col - 1])
            {
                l = m + 1;
            }
            else{
                r = m - 1;
            }
        }

        int currRow = left[0];
        int lCol = left[1];
        int rCol = right[1];
        while(lCol <= rCol){
            int m = lCol + (rCol - lCol)/2;
            if(matrix[currRow][m] == target)
            {
                return true;
            }
            else if(target < matrix[currRow][m])
            {
                rCol = m - 1;
            }
            else{
                lCol = m + 1;
            }
        }

        return false;
    }
}
