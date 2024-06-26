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


class Pair {
    int row;
    int col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // Visited matrix.
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    
                    bfs(i, j, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    void bfs(int row, int col, boolean[][] visited, char[][] grid) {
        visited[row][col] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;
        
        // 4 possible directions: up, down, left, right
        int[] dRow = {-1,-1, 0, 1, 1, 1 ,0, -1};
        int[] dCol = {0, +1, +1, +1, 0, -1, -1, -1};
        
        while (!queue.isEmpty()) {
            int currRow = queue.peek().row;
            int currCol = queue.peek().col;
            queue.remove();
            
            // Traverse all 4 neighbors
            for (int k = 0; k < 8; k++) {
                int newRow = currRow + dRow[k];
                int newCol = currCol + dCol[k];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m 
                        && grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
    }
}
