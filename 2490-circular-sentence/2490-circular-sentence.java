class Solution {
    public boolean isCircularSentence(String sentence) {
        return helper(sentence);
    }
    
    private boolean helper(String sent){
        String[] str = sent.split(" ");
        System.out.println(Arrays.toString(str));
        int n = str.length;
        
        if (n == 1) {
            String s = str[0];
            return s.charAt(0) == s.charAt(s.length() - 1);
        }
        

        for (int i = 1; i < n; i++) {
            String currString = str[i];
            String prevString = str[i - 1];
            // System.out.println("CURRENT-STRING - > "+currString);
            // System.out.println("PREVIOUS STRING -> " + prevString);
            char currChar = currString.charAt(0);
            char preChar = prevString.charAt(prevString.length() - 1);
            
             // System.out.println("CURR CHARACTER:"+currChar);
            // System.out.println("PREVIOUS CHARACTER:"+preChar);
            
            if (currChar != preChar) {
                 // System.out.println("FALSE :(");
                return false;
            }
        }
        
        return str[0].charAt(0) == str[n - 1].charAt(str[n - 1].length() - 1);
        //Compatr fist string fst ch and last string last char.
    }
}
