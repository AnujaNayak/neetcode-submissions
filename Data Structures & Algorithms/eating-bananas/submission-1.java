class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int res = 0;

        //find maximum bananas in the piles to get the last val of our binary search
        int maxBananas = 0;
        for(int i : piles)
        {
            if(i > maxBananas)
            {
                maxBananas = i;
            }
        }

        if(piles.length == h)
        {
            return maxBananas;
        }

        //binary search
        int l = 1;
        int r = maxBananas;
        while(l <= r)
        {
            int mid = l + (r-l) / 2;
            int totalTime = timeTaken(piles, mid);
            System.out.println("Mid: " + mid + " and totalTime: " + totalTime);
            
            if(totalTime <= h)
            {
                res = mid;
                r = mid - 1;
            }
            else if(totalTime >= h)
            {
                l = mid + 1;
            }
            else
            {
                res = mid;
                return res;
            }
        }
        return res;
    }
    public int timeTaken(int[] piles, int mid)
    {
        int totalTime = 0;
        for(int i = 0; i < piles.length; i++)
        {
            totalTime += (int)Math.ceil((double)piles[i] / mid);
        }
        return totalTime;
    }
}

// res = 2
// B   BBBB    BBB     BB
// 1   2345    678     910 -> 1B/hour
// 1   2 3     4 5     6   -> 2B/hour
// 1   2 3      4      5   -> 3B/hour
// 1    2       3      4   -> 4B/hour

// timeTaken = ceil(pile/k)
// => bananasEaten = 4/3 = 1.something


// [2,3,9,5] H=9
// BB  BBB  BBBBBBBBB   BBBBB
// 1/hour timeTaken = 19
// 2/hour timeTaken = 11
// 3/hour timeTaken = 9
// 4/hour timeTaken = 7
// 5/hour timeTaken = 5
// 6/hour timeTaken = 5
// 7/hour timeTaken = 5
// 8/hour timeTaken = 5
// 9/hour timeTaken = 4