package test;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.lang.instrument.*;

public class ObjectSizeExample {
//    private static volatile Instrumentation instrumentation;
//
//    public static void premain(String agentArgs, Instrumentation inst) {
//        instrumentation = inst;
//    }
//
//    public static long getObjectSize(Object obj) {
//        if (instrumentation == null) {
//            throw new IllegalStateException("Instrumentation is not available");
//        }
//        return instrumentation.getObjectSize(obj);
//    }

    public static void main(String[] args) {
        Object obj = new Object();

        // 获取对象的内存大小
        long size = ObjectSizeCalculator.getObjectSize(obj);
//        long size = getObjectSize(obj);
        System.out.println("Object size: " + size + " bytes");
    }
}
