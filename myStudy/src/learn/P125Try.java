package learn;

import com.sun.deploy.util.StringUtils;

public class P125Try {
    public boolean isPalindrome(String s) {
        s=s.replaceAll("\\W*_*","");
        s=s.toLowerCase();
        int left=0,right=s.length()-1;
        while(left<=right){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }else {
                left++;right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str="A man, a plan, a canal: Panama";
        P125Try p125Try=new P125Try();
        boolean palindrome = p125Try.isPalindrome(str);
        System.out.println(palindrome);

    }
}
