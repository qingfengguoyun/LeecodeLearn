package learn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P3 {
    public int lengthOfLongestSubstring(String s) {

        Queue<Character> queue=new LinkedList<>();
        char[] chars = s.toCharArray();

        int maxLength=0;
        int length=0;
        for(int i=0;i<chars.length;i++){
            Character character = Character.valueOf(chars[i]);
            if(!queue.contains(character)){
                queue.add(character);
                length++;
                maxLength=maxLength>length?maxLength:length;
            }else{
                while(!queue.peek().equals(character)){
                    length--;
                    queue.poll();
                }
                queue.poll();
                queue.add(character);

                maxLength=maxLength>length?maxLength:length;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        P3 p3=new P3();
        String s="abcabcbb";
        System.out.println(p3.lengthOfLongestSubstring(s));
    }
}
