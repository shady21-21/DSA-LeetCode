//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K){
        
        //first i've to computer for K elm.
        Queue<Long> q = new LinkedList<>();
        int index = 0;
        while(index<K){
            if(A[index]<0){
                q.add(A[index]);
            }
            index++;
        }
        long []res = new long[N-K+1];
        res[0] = (q.isEmpty()) ? 0 : q.peek();
        
        //now for the rest window.
        for(int i = 1;i<N-K+1;i++){
            //now check for prevElement Remove.
            if(A[i-1]<0){
                q.remove();
            }
            //upcoming element in the window to Add.
            if(A[i+K-1]<0){
                q.add(A[i+K-1]);
            }
           res[i] = (q.isEmpty()) ? 0 : q.peek(); 
        }
        return res;
    }
}