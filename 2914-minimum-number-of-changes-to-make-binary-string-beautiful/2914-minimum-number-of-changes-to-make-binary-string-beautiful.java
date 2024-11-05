class Solution {
    public int minChanges(String s) {
        int cnt = 0;
        for(int i = 1;i<s.length();i+= 2){
              System.out.println("i = " + i);
            if(s.charAt(i)!= s.charAt(i-1)){
                System.out.println("CURR CHAR : - > " + s.charAt(i));
                System.out.println("PREV CHAR : - > " + s.charAt(i-1));
                cnt++;
            }
        }
        return cnt;
    }
}