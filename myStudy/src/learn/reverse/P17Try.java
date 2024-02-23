package learn.reverse;

import java.util.*;

public class P17Try {

    Map<Character,List<String>> map=new HashMap<>();
    List<String> res=new LinkedList<>();
    public void initMap(){
        map.put('2',Arrays.asList("a","b","c"));
        map.put('3',Arrays.asList("d","e","f"));
        map.put('4',Arrays.asList("g","h","i"));
        map.put('5',Arrays.asList("j","k","l"));
        map.put('6',Arrays.asList("m","n","o"));
        map.put('7',Arrays.asList("p","q","r","s"));
        map.put('8',Arrays.asList("t","u","v"));
        map.put('9',Arrays.asList("w","x","y","z"));
    }
    public void fun(char[] datas,int index,StringBuilder term,int endPoint){
        //这里的递归结束条件第一反应为index==datas.length，但会导致长度不足的term也被保存在res中，待确认原因
        if(term.length()==datas.length){
//        if(index==datas.length){
            res.add(term.toString());
        }else{
            for(int i=index;i<datas.length;i++){
                Character key = Character.valueOf(datas[i]);
                List<String> strings = map.get(key);
                for(String str:strings){
                    term.append(str);
                    fun(datas,i+1,term,endPoint);
                    term.deleteCharAt(term.length()-1);
                }
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new LinkedList<>();
        }
        char[] chars = digits.toCharArray();
        initMap();
        StringBuilder term=new StringBuilder();
        fun(chars,0,term,chars.length);
        return res;
    }

    public static void main(String[] args) {
        P17Try p17Try=new P17Try();
        String digits="243";
        List<String> strings = p17Try.letterCombinations(digits);
        strings.stream().forEach(t->{
            System.out.println(t);
        });
    }
}
