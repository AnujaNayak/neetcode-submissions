class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        boolean added = false;
        int newS = newInterval[0];
        int newE = newInterval[1];
        for(int i = 0; i < intervals.length; i++)
        {
            int oldS = intervals[i][0];
            int oldE = intervals[i][1];
            //overlaps
            if(newS <= oldE && newE >= oldS)
            {
                newS =  Math.min(newS, oldS);
                newE = Math.max(newE, oldE);
            }
            //intervals do not overlap
            else{
                if(!added && (newS < oldS && newE < oldS))
                {
                    res.add(new int[]{newS, newE});
                    added = true;
                }
                res.add(new int[]{oldS, oldE});
            }
        }
        if(!added){
            res.add(new int[]{newS, newE});
        }
        return res.toArray(new int[res.size()][2]);
    }
}
//                      |-------|   
//                        |-----------| 
//  |------------------|
//             |------------------|
//                             |------------------|
//                                         |------------------|
//                     |------------------|
//                           |----|

// doesnt overlap:
// - newE > oldS
// - newS > oldE

// overlaps:
// - newS <= oldE && newE >= oldS

// 1-----5   7-----9   11----13
// 1-----3   7-----9   11----13
//             2----5              15----16