class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        String[]sen = sentence.split(" ");
        for(int i = 0;i<sen.length;i++){
            String currString = sen[i];
            
            if(currString.startsWith(searchWord)){return i+1;}
        }
        return -1;
    }
}