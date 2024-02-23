package learn;

import java.util.*;

public class P2454_L {

    class Data{
        Integer value;
        Integer index;

        public Data(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "value=" + value +
                    ", index=" + index +
                    '}';
        }
    }

    class MyComparator implements Comparator<Data>{

        @Override
        public int compare(Data o1, Data o2) {
            if(o1.value<=o2.value){
                return -1;
            }else{
                return 1;
            }

        }
    }



    public List<Data> convertToDataList(int[] intArray){
        LinkedList<Data> dataList = new LinkedList<>();
        for(int i=0;i<intArray.length;i++){
            Data data = new Data(intArray[i], i);
            dataList.add(data);
        }
        return dataList;
    }

    public static void main(String[] args) {
        P2454_L p2454L=new P2454_L();
        int[] ints = {5, 4, 3, 2, 1};
        List<Data> datas = p2454L.convertToDataList(ints);
        Collections.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return 0;
            }
        });
        datas.stream().forEach(t-> System.out.println(t.toString()));

    }


}
