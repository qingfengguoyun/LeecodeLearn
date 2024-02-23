package test;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public void test(){

        Teacher teacher = new Teacher(1,"李老师");
        Teacher teacher1 = new Teacher(2,"马老师");
        Teacher teacher2 = new Teacher(3,"王老师");
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);
        teachers.add(teacher1);
        teachers.add(teacher2);
        Student student = new Student(11,"张三", 1, 100);
        Student student1 = new Student(12,"李四", 1, 90);
        Student student2 = new Student(13,"王五", 1, 80);
        Student student3 = new Student(14,"小明", 2, 98);
        Student student4 = new Student(15,"李华", 2, 87);
        Student student5 = new Student(16,"cxk", 3, 60);
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        Map<Integer, Student> map1 = students.stream().collect(Collectors.toMap(v -> v.getTeacherId(), v -> v, (o, n) -> {
            return o;
        }));
        Map<Integer, String> teacherMap = teachers.stream().collect(Collectors.toMap(t -> t.getId(), t -> t.getName()));
        Map<String, List<Student>> collect = students.stream().collect(Collectors.toMap(v -> teacherMap.get(v.getTeacherId()), v -> Collections.singletonList(v), (o, n) -> {
            List<Student> list = new LinkedList<>(o);
            list.addAll(n);
            return list;
        }));
        collect.entrySet().forEach(t->{
            System.out.print(t+" ");
            t.getValue().forEach(s->{
                System.out.println(s);
            });
        });

//        map1.entrySet().stream().forEach(t->{
//            System.out.println(t.getKey()+" "+t.getValue());
//        });


    }

    public static void main(String[] args) {
        Test test=new Test();
        test.test();
    }
}
