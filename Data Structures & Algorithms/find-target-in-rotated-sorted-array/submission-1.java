class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r)
        {
            int m = l + (r-l)/2;
            if(nums[m] == target)
            {
                return m;
            }
            
            if(nums[l] <= nums[m])
            {
                if(target >= nums[l] && target <= nums[m])
                {
                    r = m - 1;
                }
                else
                {
                    l = m + 1;
                }
            }
            else
            {
                if(target >= nums[m] && target <= nums[r])
                {
                    l = m + 1;
                }
                else
                {
                    r = m -1;
                }
            }
        }
        return res;
    }
}
//       0 1 2 3 4
// nums=[5,6,1,2,3]    target=5
//       l m r

// [1,2,3,4,5]
// [5,1,2,3,4]
// [4,5,1,2,3]
// [3,4,5,1,2]

// [3,4,5,6,1,2], target = 1
//  l   m     r

//  0 1 2 3 4 5 6
// [3,4,5,6,7,1,2] target = 8
//              mrl

// t >= l && t <= m
//  look in the first half
// else
// look in right half