class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 2;i<= n;i++){
            s = addCount(s);
        }
        return s;
    }
    
    static String addCount(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char ch = s.charAt(0);
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i)==ch){
                count++;
            }else{
                sb.append(count);
                sb.append(ch);
                
                //update both value.
                ch = s.charAt(i);
                count = 1;
                
            }
        }
        sb.append(count);
        sb.append(ch);
        return sb.toString();
    }
}