class Solution {
    public boolean rotateString(String s, String goal) {
        
        Set<String>set = new HashSet<>();
        if(goal.length() != s.length()){return false;}
	   //StringBuilder sb = new StringBuilder();
// 		System.out.println(s.substring(0,1));
		for (int i = 0; i < s.length(); i++) {
            System.out.println("CURR STRING : - > " + s.substring(i));
	        System.out.println("LEFT PORTION : - > " + s.substring(0,i));
            String rotated = s.substring(i) + s.substring(0, i);
            set.add(rotated);
        }
		
		System.out.println("SET IS : " + set);
		return set.contains(goal);
    }
}