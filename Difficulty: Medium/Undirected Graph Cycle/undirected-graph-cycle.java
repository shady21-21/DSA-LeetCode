//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int fst;
    int snd;
    Pair(int fst, int snd){
        this.fst = fst;
        this.snd = snd;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean visit[] = new boolean[V];
        for(int i = 0;i<V;i++){
            if(visit[i] == false){
                if(detectCycle(i, V, adj,visit)){
                    return true;
                }
            }
        }
        return false;
        
    }
    
    boolean detectCycle(int src ,int V, ArrayList<ArrayList<Integer>> adj, boolean[] visit){
        
        visit[src] = true;
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(src, -1));
        while(!q.isEmpty()){
            int node = q.peek().fst;
            int parentNode = q.peek().snd;
            
            q.remove();
            
            for(int adjnode : adj.get(node)){
                if(visit[adjnode] == false){
                    visit[adjnode] = true;
                    q.add(new Pair(adjnode, node));
                    
                }else if(parentNode!=adjnode){
                    return true;
                }
            }
        }
        return false;
    }
}