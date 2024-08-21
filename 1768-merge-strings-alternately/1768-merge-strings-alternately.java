class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(word1.length() > i && word2.length() > j){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }
        while(word1.length() > i){
            sb.append(word1.charAt(i));
            i++;
        }
         while(word2.length() > j){
            sb.append(word2.charAt(j));
            j++;
        }
        
        
        return sb.toString();
    }
}