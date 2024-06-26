//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){
       int[] color = new int[V];
       //fill the color array with -1..
       Arrays.fill(color, -1);
       
       for(int i = 0;i<V;i++){ //this loop is for individul components.
           if(color[i] == -1){
               if(checkBipartite(i, V, adj,color) == false){
                   return false;
               }
           }
       }
       return true;
    }
    
    boolean checkBipartite(int startnode, int V,ArrayList<ArrayList<Integer>>adj, int[]color){
        Queue<Integer> q = new LinkedList<>();
        q.add(startnode);
        color[startnode] = 0;
        
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            
            for(int it:adj.get(node)){
                //check my current node corresponding node are coolor or not?
                if(color[it] == -1){
                    //menas doe't color yet.
                    //so color that.
                    color[it] = 1 - color[node]; //menas currnode color 0 then adjnode color 1.    !color[node]
                    q.add(it);
                }else if(color[it] == color[node]){//if color are same means currnode color or adjnode color are same.
                    return false; //this is't bipartite graph.
                }
                
            }
        }
        return true;
    }
    
}