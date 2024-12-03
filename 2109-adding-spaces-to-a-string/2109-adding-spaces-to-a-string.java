class Solution {
    public String addSpaces(String s, int[] spaces) {
        
        StringBuffer stringBuffer = new StringBuffer(s);
        
        int cnt = 0; //track the number of space added
        for(int i = 0;i<spaces.length;i++){
            int pos = spaces[i] + cnt;
            stringBuffer.insert(pos, ' ');
            cnt++;
        }
        return stringBuffer.toString();
    }
}