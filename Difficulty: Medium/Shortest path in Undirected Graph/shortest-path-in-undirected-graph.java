//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        //crete graph of this matrix edges.
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //graph.
        for(int i = 0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int dis[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        //initi with Intifinity.
        for(int i = 0;i<n;i++)dis[i] = (int)(1e9);
        dis[src] = 0; //push src node as dis 0
        q.add(src);
        
        while(!q.isEmpty()){
            int currNode = q.peek();
            q.remove();
            
            //iterate to the adj node.
            for(int it: adj.get(currNode)){
                if(dis[currNode] + 1 < dis[it]){
                    dis[it] = dis[currNode] + 1;
                    q.add(it);
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(dis[i] == 1e9) dis[i] = -1;
        }
        return dis;
    }
}