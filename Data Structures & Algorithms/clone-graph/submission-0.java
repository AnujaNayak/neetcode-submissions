/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        //1. This hashmap is to keep track of what nodes we have already seen. 
        //If 1 <->2 are connected, without hashmap, after popping 1 from q, 
        //when processing 2 from q, we'll end up in a loop where we process 
        //1 again because 1 wasn't in our "seen" hm.
        //2. Also, hm helps grab the new node easily and update its neighbors.
        if(node == null){
            return null;
        }
        HashMap<Node, Node> hm = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        hm.put(node, new Node(node.val));

        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node nei : curr.neighbors)
            {
                if(!hm.containsKey(nei))
                {
                    q.add(nei);
                    hm.put(nei, new Node(nei.val));
                }
                hm.get(curr).neighbors.add(hm.get(nei));
            }
        }
        return hm.get(node);
    }
}
