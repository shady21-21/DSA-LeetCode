class Solution {
    public int countSubstrings(String s) {
        
        int count = 0;
        for(int i = 0;i<s.length();i++){
            for(int j = i+1;j<=s.length();j++){
                if(isPaildrom(s.substring(i, j)) == true){
                    count++;
                }
            }
        }
        return count;
    }
   
    static boolean isPaildrom(String s){ //aaa
        for(int i= 0;i<s.length();i++){
            if(s.charAt(i)!= s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}