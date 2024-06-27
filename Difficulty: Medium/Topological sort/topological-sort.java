//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        
        //Step 1: First cal the indegree .
        int[] indeg = new int[V];
        for(int i = 0;i<V;i++){
            for(int it: adj.get(i)){
                indeg[it]++;
            }
        }
        //Step 2: Create a queue and put those node whose indeg are 0
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        
        //Step 3: While my queue is't empty take out that node reduce their indeg and while removeing if indeg is 0 put that into Queue.
        int[]ans = new int[V];
        int i = 0;
        while(!q.isEmpty()){
            int currNode = q.peek();
            q.remove();
            ans[i++] = currNode;
            
            //now check the currNode adj node.
            for(int it: adj.get(currNode)){
                //now decrease their indeg.
                indeg[it] --;
                //while decreaing if indeg is 0 put it into q.
                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }
        return ans;
    }
}
