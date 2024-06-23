//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends






class Solution {
   
    public static void dfs(char[][] grid, boolean[][] vis, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = true;
        
        //traversa their neighbour and mark them land...
        for(int delrow = -1; delrow <= 1; delrow++) {
            for(int delcol = -1; delcol <= 1; delcol++) {
                int newRow = row + delrow;
                int newCol = col + delcol;
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && 
                vis[newRow][newCol] == false && grid[newRow][newCol] == '1') {
                    dfs(grid, vis, newRow, newCol);
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
       
      int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n+1][m+1];
        
        int counter = 0;
        for(int i=0; i< n; i++) {
            for(int j=0; j<m; j++) {
                if(vis[i][j] == false && grid[i][j] == '1') {
                    counter++;
                    dfs(grid, vis, i, j);
                }
            }
        }
        
        return counter;
    }

}

