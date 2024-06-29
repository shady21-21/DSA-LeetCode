//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair{
    int vrtx;
    int wt;
    Pair(int vrtx, int wt){
        this.vrtx = vrtx;
        this.wt = wt;
    }
}

class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
		for(int i = 0;i<N;i++){
		   adj.add(new ArrayList<Pair>());
		}
		
		//take the ege, vertex and weight from 2D metrix.
		for(int i = 0;i<M;i++){
		    int e = edges[i][0];
		    int v = edges[i][1];
		    int w = edges[i][2];
		    //then add this into adj list of list as a pair.
		    adj.get(e).add(new Pair(v, w));
		}
		
		//Step 1: Do topo sort in this graph.
		int[]vis = new int[N];
		Stack<Integer> stk = new Stack<>();
		for(int i = 0;i<N;i++){
		    if(vis[i] == 0){
		        topoSort(i, adj, vis, stk);
		    }
		}
		
		//Step 2: Do the distance stuff.
		int[]dist = new int[N];
		for(int i= 0;i<N;i++){
		  //  dist[i] = Integer.MAX_VALUE;
		    dist[i] = (int)(1e9);
		}
		dist[0] = 0;
		while(!stk.isEmpty()){
		    int currNode = stk.peek();
		    stk.pop();
		    for(int i = 0;i<adj.get(currNode).size();i++){
		        int vertex = adj.get(currNode).get(i).vrtx;
		        int weight = adj.get(currNode).get(i).wt;
		        
		        if(dist[currNode] + weight < dist[vertex]){
		            dist[vertex] = weight + dist[currNode];
		        }
		    }
		}
		for (int i = 0; i < N; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
		return dist;
	}
	
	void topoSort(int node,ArrayList<ArrayList<Pair>>adj,int[]vis,Stack<Integer> stk){
	    vis[node] = 1;
	    for(int i = 0;i<adj.get(node).size();i++){
	        int vertex = adj.get(node).get(i).vrtx;
	        if(vis[vertex] == 0){
	           topoSort(vertex, adj, vis, stk); 
	        }
	    }
	    
	    stk.add(node);
	}
}