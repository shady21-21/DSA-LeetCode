class Solution {
    public boolean isBalanced(String num) {
        
        int sumEven = 0;
        int sumOdd = 0;
        
        char[]str = num.toCharArray();
        
        for(int i = 0;i<str.length;i++){
            int x = Character.getNumericValue(num.charAt(i));
           if(i%2 == 0){
               // System.out.println(" EVEN : - > " + x);
               sumEven += x;
               
           }else{
               // System.out.println(" ODD : - > " + x);
               sumOdd += x;
           }
        }
        return (sumEven == sumOdd) ? true: false;
    }
}