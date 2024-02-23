package test;

import java.util.HashMap;
import java.util.Map;

public class OutOfMemeryTest {
    public static void main(String[] args) {
        System.out.println("OutOfMemoryTest");
        int i=0;
        Map map=new HashMap<String,String>();
        Map<Integer,byte[]> map2=new HashMap();
        while(true){
            System.out.println("running"+i);
            map.put("str"+i,"str"+i);
            map2.put(i,new byte[1000*1000]);
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
