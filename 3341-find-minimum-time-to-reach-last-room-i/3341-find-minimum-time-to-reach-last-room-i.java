class Pair{
    int x;
    int y;
    int dis;
    
    public Pair(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        
        int n = moveTime.length;
        int m = moveTime[0].length;
        
        boolean[][] isVis = new boolean[n][m];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b){
                return a.dis - b.dis;
            }
        });
        
        pq.offer(new Pair(0, 0, 0));
        isVis[0][0] = true;
        while(!pq.isEmpty()){
            Pair currNode = pq.poll();
            int row = currNode.x;
            int col = currNode.y;
            int dis = currNode.dis;
            
            if(row == n-1 && col == m-1){return dis;}
            
            //for move 4 dir.
            int[]xDir = {-1, 1, 0, 0};
            int[]yDir = {0, 0, -1, 1};
            for(int i= 0;i<4;i++){
                int newR = row + xDir[i];
                int newC = col + yDir[i];
                
                if(isValid(newR, newC, n, m) && !isVis[newR][newC]){
                    int timeReq = Math.max(moveTime[newR][newC], dis);
                    pq.offer(new Pair(newR, newC, timeReq+1));
                    isVis[newR][newC] = true;
                }
            }
        }
        return -1;
    }
    
    public boolean isValid(int newR, int newC , int n , int m){
        return newR>= 0 && newC >= 0 && n > newR && m > newC;
    }
}