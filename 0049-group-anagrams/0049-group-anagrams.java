class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            String freqString = calFreqString(s);
            if(map.containsKey(freqString)){
                //do some operations
                map.get(freqString).add(s);
            }else{
                List<String>list = new ArrayList<>();
                list.add(s);
                map.put(freqString, list);
                
            }
        }
        return new ArrayList<>(map.values());
    }
     
    static String calFreqString(String s){ //tea
        int[]freq = new int[26];
        for(char ch : s.toCharArray()){
           freq[ch - 'a']++; 
        }
        
        StringBuilder sb = new StringBuilder("");
        char c = 'a';
        for(int i :freq){
            sb.append(c);
            sb.append(i);
            c++;
        }
        return sb.toString(); // "a1e1t1"
    }
}