//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
       
       
       long maxSum = 0;
       long sum = 0;
       
       int index = 0;
       //first i've to cal for k'th ele
       while(index<N && index < K){
           sum += Arr.get(index);
           index++;
       }
       //update my maxSum.
       maxSum = sum;
       //Now i wil compute for 1st index.
       for(int i = 1;i<N-K+1;i++){
        //now move my frame ahead in a way that prev element is substract and next element is add.
         sum = sum - Arr.get(i-1) + Arr.get(i+K-1);
         maxSum = Math.max(maxSum, sum);
       }
       
       return maxSum;
    }
}