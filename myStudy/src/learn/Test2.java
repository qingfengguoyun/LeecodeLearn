package learn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public void streamTest(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list.stream().forEach(t->{
            if(t%3==0){
                list.remove(list.indexOf(t));
            }
        });
        list.stream().forEach(t-> System.out.println(t));
    }

    public void streamTest2(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list=list.stream().map(t->{
            return t+2;
        }).collect(Collectors.toList());
        list.stream().forEach(t-> System.out.println(t));
    }

    public void test(){
        int i1=-2147483646;
        int i2=2147483646;
        System.out.println(i1-i2);
    }

    public void test3(){
        String str="DevelopmentAnalog";
        System.out.println(str.contains("Analog"));
    }

    public static void main(String[] args) {
        Test2 test2=new Test2();
        test2.test3();
    }
}
