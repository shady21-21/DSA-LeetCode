class Solution {
    public int maximumLength(String s) {
        
        
        HashMap<String,Integer> map = new HashMap<>();
        
        int n = s.length();
        for(int i = 0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = i;j<n;j++){
                if(sb.length() == 0 || 
                  s.charAt(j) == sb.charAt(sb.length()-1)){
                    sb.append(s.charAt(j));
                    //covert into string.
                    String curr = sb.toString();
                    map.put(curr, map.getOrDefault(curr, 0)+1);
                }else{
                    break;
                }
            }
        }
        
        int maxLen = -1;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String str = entry.getKey();
            int freq = entry.getValue();
            if(freq > 2){
                maxLen = Math.max(maxLen, str.length());
            }
        }
        return maxLen;
    }
}