//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    if(order.length() != k){
		        System.out.println("INCOMPLETE");
		        return;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K){
 
       // Make adjacency list for the graph representation
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        
       //convert this dict array of string into adj list.
       for( int i = 0;i<N-1;i++){
           String str1 = dict[i];
           String str2 = dict[i+1];
           
           //now take the min len among them 
           int  len = Math.min(str1.length(), str2.length());
           for(int j = 0;j<len;j++){
               if(str1.charAt(j) != str2.charAt(j)){
                   adj.get(str1.charAt(j) - 'a').add(str2.charAt(j) - 'a');  
                   //convert into 0 1 2 .. format graph.
                   break; 
               }
           }
       }
       //call the topo sort.
       ArrayList<Integer> topo = topoSort(K, adj);
       String ans = "";
       for(int it: topo){
           ans = ans + (char)(it + (int)('a'));
       }
       return ans;
    }
    
    ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] indeg = new int[V];
        for(int i = 0;i<V;i++){
            for(int it: adj.get(i)){
                indeg[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int currNode = q.peek();
            q.remove();
            topo.add(currNode);
            
            //decrease the indeg.
            for(int it: adj.get(currNode)){
                indeg[it]--;
                if(indeg[it] == 0) q.add(it);
            }
        }
        return topo;
    }
}