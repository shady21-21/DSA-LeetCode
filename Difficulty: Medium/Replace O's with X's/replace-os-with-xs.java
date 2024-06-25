//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][]){
        
        //create a visited array.
        int[][] vis = new int[n][m];
        
        //Traversal fist row and last row.
        for(int i = 0;i<m;i++){
            //first row.
            if(vis[0][i] == 0 && a[0][i] == 'O'){
                dfs(0, i, vis, a);
            }
            //last row.
            if(vis[n-1][i] == 0 && a[n-1][i] == 'O'){
                dfs(n-1, i, vis, a);
            }
        }
        
        //Traverse first col and last col.
        for(int j = 0;j<n;j++){
            //fisrt col.
            if(vis[j][0] == 0 && a[j][0] == 'O'){
                dfs(j, 0, vis, a);
            }
            //last col.
            if(vis[j][m-1] == 0 && a[j][m-1] == 'O'){
                dfs(j, m-1, vis, a);
            }
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(vis[i][j] == 0 && a[i][j] == 'O'){
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }
    
    static void dfs(int row, int col, int[][]vis, char[][]a){
        int n = a.length;
        int m = a[0].length;
        vis[row][col] = 1; // to mark the current cell as visited to avoid revisiting.
        int[] delrow = { -1, 0, +1, 0};
        int[] delcol = {0, 1, 0, -1};
        
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
            && vis[nrow][ncol] == 0 && a[nrow][ncol] == 'O'){
                dfs(nrow, ncol, vis, a);
            }
        }
    }
}