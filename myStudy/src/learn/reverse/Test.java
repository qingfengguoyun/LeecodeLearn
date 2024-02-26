package learn.reverse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 5, 6, 3, 6, 8);
        list= list.stream().sorted((t1, t2) -> {
            return t1 < t2 ? 1 : -1;
        }).collect(Collectors.toList());
        list.stream().forEach(t->{
            System.out.print(t+" ");
        });
    }
}
