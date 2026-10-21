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
    /*
        general idea 
        1. copy the current node and go to the next node, return the node which already built
        2. use dfs iterate whole graph
    */

    HashMap<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
        {
            return node;
        }

        if(map.containsKey(node))
        {
            return map.get(node);
        }

        Node cpNode = new Node(node.val);
        map.put(node,cpNode);

        for(Node next : node.neighbors)
        {
            cpNode.neighbors.add(cloneGraph(next));
        }

        return cpNode;
    }
}