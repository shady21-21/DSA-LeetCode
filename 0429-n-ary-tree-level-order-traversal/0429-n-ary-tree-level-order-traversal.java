/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){return list;}
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer>levelList = new ArrayList<>();
            while(size>0){
                Node currNode = q.poll();
                levelList.add(currNode.val);
                for(Node child : currNode.children){
                    if(child!= null){
                        q.offer(child);
                    }
                }
                size--;
            }
             System.out.println("CURRENT LEVEL : -> " + levelList);
             list.add(levelList);
        }
        return list;
    }
}