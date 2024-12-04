class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        
        
        int i = 0;
        int j = 0;
        if(str2.length() > str1.length()){return false;}
        
        while(i<str1.length() && j<str2.length()){
            if(str1.charAt(i) == str2.charAt(j) ||
               str1.charAt(i) == str2.charAt(j)-1||
               (str1.charAt(i) == 'z' && str2.charAt(j) == 'a')){
                j++;
            }
            i++;
        }
        
        return j == str2.length();
    }
}