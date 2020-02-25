package designPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 单例模式
 *
 * @author wpz
 * @date 2020/2/17 21:05
 */
public class Singleton {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.clear();
    }

    /**
     * 饿汉式(线程安全)  缺点 不能懒加载
     */
    static class HungryManSingleton {

        private static HungryManSingleton singleton = new HungryManSingleton();

        private HungryManSingleton() {
        }

        public static HungryManSingleton getSingleton() {
            return singleton;
        }
    }

    /**
     * 懒汉式(线程不安全)  可以延迟加载
     */
    static class IdlerSingleton {
        private static IdlerSingleton idlerSingleton;
        private IdlerSingleton() {
        }
        public static IdlerSingleton getIdlerSingleton() {
            if (idlerSingleton == null) {
                idlerSingleton = new IdlerSingleton();
            }
            return idlerSingleton;
        }
    }


    /**
     * 懒汉模式(线程安全) 缺点: synchronized 浪费资源
     */
    static class IdleSingletonSafe {

        private static IdleSingletonSafe idleSingletonSafe;

        private IdleSingletonSafe() {
        }

        public synchronized IdleSingletonSafe getIdleSingletonSafe() {
            if (idleSingletonSafe == null) {
                idleSingletonSafe = new IdleSingletonSafe();
            }
            return idleSingletonSafe;
        }
    }

    /**
     * 枚举单例
     */
    public enum enumSingleton {
        /**
         * INSTANCE
         */
        INSTANCE;

        public void doSomething() {
            System.out.println("doSomething!");
        }
    }

    /**
     * 静态内部类方式创建  静态内部类不会在单例加载时就加载，而是在调用getInstance()方法时才进行加载， 达到了类似懒汉模式的效果，而这种方法又是线程安全的
     */
    static class OuterClassSingleton {

        private static class SingletonHolder {

            private static OuterClassSingleton instance = new OuterClassSingleton();
        }

        private OuterClassSingleton() {
        }

        public OuterClassSingleton getInstance() {
            return SingletonHolder.instance;
        }
    }

    /**
     * 双重检查锁单例
     */
    static class DCLSingleton {

        private static DCLSingleton instance;

        private DCLSingleton() {
        }

        public static DCLSingleton getInstance() {
            if (instance == null) {
                synchronized (DCLSingleton.class) {
                    if (instance == null) {
                        /*
                         * 创建对象分为以下三个步骤，编译器存在指令重排，可能导致获取到未初始化完成的对象
                         * 1.分配内存空间
                         * 2.初始化对象
                         * 3.将对象指向刚分配的内存空间
                         */
                        instance = new DCLSingleton();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 双重检查锁单例改进
     */
    static class DCLSingleton2 {

        /**
         * volatile关键字的一个作用是禁止指令重排，把instance声明为volatile之后，对它的写操作就会有一个内存屏障（什么是内存屏障？），这样，在它的赋值完成之前，就不用会调用读操作。 注意：volatile阻止的不singleton =
         * newSingleton()这句话内部[1-2-3]的指令重排，而是保证了在一个写操作（[1-2-3]）完成之前，不会调用读操作（if (instance == null)）
         */
        private static volatile DCLSingleton2 instance;

        private DCLSingleton2() {
        }

        public static DCLSingleton2 getInstance() {
            if (instance == null) {
                synchronized (DCLSingleton.class) {
                    if (instance == null) {
                        instance = new DCLSingleton2();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * ThreadLocal会为每一个线程提供一个独立的变量副本，从而隔离了多个线程对数据的访问冲突
     */
    static class ThreadLocalSingleton {

        private static final ThreadLocal<ThreadLocalSingleton> threadlocal =
            ThreadLocal.withInitial(() -> new ThreadLocalSingleton());


        private ThreadLocalSingleton() {
        }

        public static ThreadLocalSingleton getInstance() {
            return threadlocal.get();
        }
    }


    /**
     * 利用AtomicReference
     */
    private static final AtomicReference<CASSingleton> INSTANCE = new AtomicReference<CASSingleton>();

    /**
     * 使用CAS
     */
    static class CASSingleton {

        private CASSingleton() {
        }

        /**
         * 用CAS确保线程安全
         */
        public static CASSingleton getInstance() {
            for (; ; ) {
                CASSingleton current = INSTANCE.get();
                if (current != null) {
                    return current;
                }
                current = new CASSingleton();
                if (INSTANCE.compareAndSet(null, current)) {
                    return current;
                }
            }
        }
    }

}
