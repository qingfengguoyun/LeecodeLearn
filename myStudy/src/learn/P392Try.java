package learn;

public class P392Try {

    public boolean isSubsequence(String s, String t) {
        if("".equals(s)){
            return true;
        }
        int i=0,j=0;
        for(;j<t.length();){
            if(i==s.length()){
                return true;
            }
            if(t.charAt(j)==s.charAt(i)){
                i++;j++;
                if(i==s.length()){
                    return true;
                }
            }else{
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P392Try p392Try=new P392Try();
        String s="abc";
        String t="ahbgdc";
        boolean subsequence = p392Try.isSubsequence(s, t);
        System.out.println(subsequence);
    }
}
