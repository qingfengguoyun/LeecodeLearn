package test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue<Object> refQueue=new ReferenceQueue<>();
        String obj="123";
        SoftReference<Object> softRef=new SoftReference<>(obj,refQueue);

        // 创建一个弱引用对象
        WeakReference<Object> weakRef = new WeakReference<>(new Object());

        // 打印 GC 信息
//        System.gc();
//        System.runFinalization();
//        System.out.println("After GC, weakRef is " + weakRef.get());

        // 启用 -XX:+PrintReferenceGC 参数
//        System.setProperty("java.lang.ref.Reference.reachabilityFence", "true");
//        System.out.println("Enable -XX:+PrintReferenceGC");

        // 打印 GC 信息


        System.gc();
        System.runFinalization();
        System.out.println("After GC, softRef is " + softRef.get().toString());
        System.out.println("After GC, weakRef is " + weakRef.get());
//        System.out.println(refQueue.poll().get());
//        if(refQueue.poll()!=null){
//
//        }
    }
}
