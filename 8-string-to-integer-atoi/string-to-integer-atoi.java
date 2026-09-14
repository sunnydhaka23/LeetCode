class Solution{
    public int myAtoi(String s){
        int i=0,sign=1,num=0;
        while(i<s.length()&&s.charAt(i)==' ')i++;
        if(i<s.length()&&(s.charAt(i)=='+'||s.charAt(i)=='-')){
            if(s.charAt(i)=='-')sign=-1;
            i++;
        }
        while(i<s.length()&&Character.isDigit(s.charAt(i))){
            int d=s.charAt(i)-'0';
            if(num>(Integer.MAX_VALUE-d)/10)
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            num=num*10+d;
            i++;
        }
        return num*sign;
    }
}