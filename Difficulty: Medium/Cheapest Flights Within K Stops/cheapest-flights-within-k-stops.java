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
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Tuple{
    int node;
    int distance;
    int stops;
    
    Tuple(int node, int distance, int stops){
        this.node = node;
        this.distance = distance;
        this.stops = stops;
    }
}

class Pair{
    int node;
    int distance;
    Pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}


class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
      
      // craete adj list of the given 2D matrix.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        int m = flights.length;
        for(int i =0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        int[]dist = new int[n];
        for(int i = 0;i<n;i++)dist[i] = (int)(1e9);
        Queue<Tuple> q = new LinkedList<>();
        dist[src] = 0;
        q.add(new Tuple(src, 0, 0));
        
        while(!q.isEmpty()){
            int currNode = q.peek().node;
            int distance = q.peek().distance;
            int stops = q.peek().stops;
            q.remove();
            
            // if my getting stops are greater than k then, stop.
            if(stops > k)continue;
            for(Pair it: adj.get(currNode)){
                int adjNode = it.node;
                int edgW = it.distance;
                
                if(distance + edgW < dist[adjNode] && stops <= k){
                    dist[adjNode] = distance + edgW;
                    q.add(new Tuple(adjNode, distance + edgW, stops+1));
                }
            }
        }
        
        if(dist[dst] == (int)(1e9))return -1;
        return dist[dst];
    }
}