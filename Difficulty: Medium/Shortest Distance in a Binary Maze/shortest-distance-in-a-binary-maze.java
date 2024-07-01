//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int row;
    int col;
    int distance;
    
    public Pair(int row, int col, int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}


class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        
        //edge case is that  if src is my des then 
        if(source[0] == destination[0] && source[1] == destination[1])return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        
        int dis[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                dis[i][j] = (int)(1e9);
            }
        }
        // in dis array fill the src with 0
        dis[source[0]][source[1]] = 0;
        Queue<Pair> q = new LinkedList<>();
        //add the pair into queue.
        q.add(new Pair(source[0], source[1], 0));
        
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, +1, 0, -1};
        
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dist = q.peek().distance;
            q.remove();
            
            for(int i = 0 ;i<4;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                
                if(nRow>=0 && nRow < n && nCol>=0 && nCol< m 
                && grid[nRow][nCol] == 1 && dis[nRow][nCol]> dist + 1){
                    dis[nRow][nCol] = dist + 1;
                    
                    //befor adding into q check am i reach into my desination.
                    if(nRow == destination[0] && nCol == destination[1])return dist +1;
                    q.add(new Pair(nRow, nCol, dist + 1));
                }
            }
        }
        return -1; //not find any valid path
    }
}
