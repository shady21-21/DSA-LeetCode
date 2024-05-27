class Solution {
    public int lengthOfLongestSubstring(String s) {
       
        int ans = 0;
        
        HashSet<Character> set = new HashSet<>();
        //take two pointer.
        int left = 0;
        int right = 0;
        while(right<s.length()){
            //check the left pointer char is on the set or not
            if(set.contains(s.charAt(right))){
                //do some op
                //if present
                set.remove(s.charAt(left));
                left++;
            }else{
                set.add(s.charAt(right));
                right++;
                int sizeOfSet = set.size();
                //compair with ans 
                ans = Math.max(ans,sizeOfSet);
            }
        }
        
        
        return ans;
    }
}