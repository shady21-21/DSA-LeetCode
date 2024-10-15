class Solution {
    public long minimumSteps(String s) {
        
        //pattern similar to move zero to end.
        char[]str = s.toCharArray();
        int n = str.length;
        int i = 0;
        int j = 0;
        
        long cnt = 0;
        while(i<n && j<n){
            if(str[i] == '1'){
                i++;
            }else{
                cnt+= (i-j);
                i++;
                j++;
            }
        }
        return cnt;
    }
}