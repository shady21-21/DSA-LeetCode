//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Pair{
    int row;
    int col;
    int distance;
    
    Pair(int row, int col , int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}


class Solution {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
       
       int[][] dis = new int[rows][columns];
       //fill that with infinity value.
       for(int i = 0;i<rows;i++){
           for(int j = 0;j<columns;j++){
               dis[i][j] = (int)(1e9);
               
           }
       }
       dis[0][0] = 0;
       
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.add(new Pair(0, 0, 0));
        
        int[] delRow = {-1 , 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        while(!pq.isEmpty()){
            //take one by one.
            int row = pq.peek().row;
            int col = pq.peek().col;
            int dist = pq.peek().distance;
            pq.remove();
            
            if(row == rows -1 && col == columns-1)return dist;
            
            for(int i =0;i<4;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                
                
                
                if(nRow>= 0 && nRow < rows && nCol>=0 && nCol < columns){
                    //cal the effort.
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[nRow][nCol]), dist);
                    
                    if(newEffort< dis[nRow][nCol]){
                        dis[nRow][nCol] = newEffort;
                        pq.add(new Pair(nRow, nCol,newEffort));
                    }
                }
            }
            
        }
    return 0;
    }
}
