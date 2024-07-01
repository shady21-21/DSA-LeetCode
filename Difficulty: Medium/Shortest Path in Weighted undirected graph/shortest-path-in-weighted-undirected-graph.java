//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends

class Pair{
    int node;
    int distance;
    
    Pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        
        //convert the edges matrix to graph.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<= n;i++){
            adj.add(new ArrayList<>());
        }
        //craete adj lists.
        for(int i = 0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        PriorityQueue<Pair> pq = new 
                            PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[]dis = new int[n+1];
        int[]parent = new int[n+1];
        for(int i = 1;i<= n ;i++){
            dis[i] = (int)(1e9); //distance arr should fill with infinity
            parent[i] = i; // parent will fill with indexes.
        }
        
        dis[1] = 0;
        //now put src node with the dis.
        pq.add(new Pair(1, 0));
        
        while(!pq.isEmpty()){
            int currNode = pq.peek().node;
            int currDis = pq.peek().distance;
            pq.remove();
            
            for(Pair it: adj.get(currNode)){
                int adjNode = it.node;
                int adjDis = it.distance;
                
                if(currDis + adjDis < dis[adjNode]){
                    dis[adjNode] = currDis + adjDis;
                    pq.add(new Pair(adjNode,currDis + adjDis));
                    
                    //update the parent node.
                    parent[adjNode] = currNode;
                }
            }
            
        }
        
        ArrayList<Integer> path = new ArrayList<>();
        if(dis[n] == (int)(1e9)){
            path.add(-1);
            return path;
        }
        
        //this is the approach to find the path.
        int node = n;
        while(parent[node]!= node){
            path.add(node);
            node = parent[node]; // update the node
        }
        // manually add the src node.
        path.add(1);
        //now reverse the list.
        Collections.reverse(path);
        
        //add the total dis of the patha at the first node.
        path.add(0, dis[n]);
        return path;
    }
}