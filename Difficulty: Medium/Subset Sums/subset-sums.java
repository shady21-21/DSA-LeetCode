//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
       
       ArrayList<Integer> list = new ArrayList<>();
       findSubSet(0, 0, n,arr, list);
       return list;
       
    }
    
    void findSubSet(int index, int sum, int n , ArrayList<Integer> arr, ArrayList<Integer>ds){
        
        if(index == n){
            ds.add(sum);
            return;
        }
        
        //if pick the particular element.
        findSubSet(index+1, sum + arr.get(index),n, arr, ds);
        //if i'm not picking.
        findSubSet(index+1, sum,n, arr, ds);
    }
}