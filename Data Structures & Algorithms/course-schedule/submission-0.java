class Solution {
    HashMap<Integer, List<Integer>> prereqMap = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < prerequisites.length; i++)
        {
            int key = prerequisites[i][0];
            if(!prereqMap.containsKey(key))
            {
                prereqMap.put(key, new ArrayList<>());
            }
            prereqMap.get(key).add(prerequisites[i][1]);
        }

        for(int i = 0; i < numCourses; i++)
        {
            boolean finishYes = dfs(i);
            if(finishYes == false)
            {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int course)
    {
        if(visited.contains(course))
        {
            return false;
        }
        if(prereqMap.get(course) == null)
        {
            return true;
        }

        visited.add(course);
        for(int preReq : prereqMap.get(course))
        {
            boolean noCycle = dfs(preReq);
            if(!noCycle)
            {
                return false;
            }
        }
        visited.remove(course);
        prereqMap.put(course, new ArrayList<>());
        return true;
    }
}

