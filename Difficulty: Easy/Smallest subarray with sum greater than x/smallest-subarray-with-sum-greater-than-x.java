//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            System.out.println(solution.smallestSubWithSum(x, arr));

            T--;
        }
    }
}

// } Driver Code Ends

 
// User function Template for Java

class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {
        
        int stWindow = 0;
        int endWindow = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int len = 0;
        
        while(endWindow < arr.length){
            //this is Expand my window.
            sum+= arr[endWindow];
            if(sum>x){
                //cal my len
                len = (endWindow - stWindow) + 1;
                minLen = Math.min(minLen, len);
            }
            
            //now Scrync the window.
            while(endWindow > stWindow && sum > x){
                sum-= arr[stWindow];
                stWindow++;
                
                if(sum>x){
                //cal my len
                len = (endWindow - stWindow) + 1;
                minLen = Math.min(minLen, len);
                }
            }
            endWindow++;
        }
        
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
