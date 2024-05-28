class Solution {
    public int beautySum(String s) {
        int sum = 0;
        for(int i = 0;i<s.length();i++){
            int[]freq = new int[26];
            for(int j = i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;
                int maxFrq = getMax(freq);
                int minFeq = getMin(freq);
                
                int beauty = maxFrq - minFeq;
                sum+= beauty;
            }
        }
        return sum;
    }
    
    static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<26;i++){
            if(arr[i]!= 0){
                max = Math.max(max, arr[i]); 
            }
        }
        return max;
    }
    
    static int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<26;i++){
            if(arr[i]!= 0){
                min = Math.min(min, arr[i]); 
            }
        }
        return min;
    }
}