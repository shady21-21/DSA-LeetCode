class Solution {
    public int maxTwoEvents(int[][] events) {
        
        //sort base on end time .
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[1] - y[1]);
        
        //sort base on start time.
        Arrays.sort(events, (x,y) -> x[0] - y[0]);
        
        int prevMax = 0;
        int res = 0;
        for(int[]event : events){
            //find prev max.
            while(!pq.isEmpty() && pq.peek()[1] < event[0]){
                prevMax = Math.max(prevMax, pq.peek()[2]); //here store the val.
                pq.poll();
            }
            
            res = Math.max(res, prevMax + event[2]);
            pq.offer(event);
        }
        return res;
    }
}