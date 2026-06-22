class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0 ; i < nums.length; i++)
        {
            hs.add(nums[i]);
        }
        for(int i = 1; i <= nums.length; i++)
        {
            if(!hs.contains(i))
            {
                res.add(i);
            }
        }
        return res;
    }
}
// hs = 1,2,3,4,7,8 || 1

// 1,2,3,4,5,6,7,8