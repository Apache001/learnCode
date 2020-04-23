package designPattern.observer;

/**
 *
 * @author wangpengzhe
 * @date 2020/4/22 20:36
 */
public class Test {

    public static void main(String[] args) {
        ConcreatOneSubject concreatOneSubject = new ConcreatOneSubject();
        ConcreatOneObserve one = new ConcreatOneObserve("one");
        ConcreatOneObserve two = new ConcreatOneObserve("two");
        ConcreatOneObserve three = new ConcreatOneObserve("three");

        concreatOneSubject.attach(one);
        concreatOneSubject.attach(two);
        concreatOneSubject.attach(three);
        concreatOneSubject.notifyMes("ceshi");
    }
}
