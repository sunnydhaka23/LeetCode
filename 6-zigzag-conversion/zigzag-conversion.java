class Solution{
    public String convert(String s,int n){
        if(n==1||n>=s.length())return s;
        StringBuilder[] rows=new StringBuilder[n];
        for(int i=0;i<n;i++)rows[i]=new StringBuilder();
        int r=0,d=1;
        for(char c:s.toCharArray()){
            rows[r].append(c);
            if(r==0)d=1;
            if(r==n-1)d=-1;
            r+=d;
        }
        StringBuilder ans=new StringBuilder();
        for(StringBuilder row:rows)ans.append(row);
        return ans.toString();
    }
}