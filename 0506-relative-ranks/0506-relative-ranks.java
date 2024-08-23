class Solution {
    class Pair implements Comparable<Pair>{
        int ele;
        int index;
        
        Pair(int ele, int index){
            this.ele = ele;
            this.index = index;
        }
        
        @Override
        public int compareTo(Pair p2){
           return p2.ele - this.ele; //sort in decending order.
        }
    }
    public String[] findRelativeRanks(int[] score) {
        
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        //add score in pq.
        for(int i = 0;i<score.length;i++){
            pq.add(new Pair(score[i], i));
        }
        
        String[]res = new String[score.length];
        // while(pq.size() > 4){
        //     Pair p = pq.poll();
        //     res[p.index] = "Gold Medal"
        // }
        
        int index = 1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(index == 1){
                res[p.index] = "Gold Medal";
            }else if(index == 2){
                 res[p.index] = "Silver Medal";
            }else if(index == 3){
                 res[p.index] = "Bronze Medal";
            }else{
               res[p.index] = String.valueOf(index); 
            }
            index++;
        }
        return res;
    }
}