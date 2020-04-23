package designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangpengzhe
 * @date 2020/4/22 20:31
 */
public class ConcreatOneSubject implements Subject {

    List<Observe> list = new ArrayList<>();

    @Override
    public void attach(Observe observe) {
        list.add(observe);
    }

    @Override
    public void detach(Observe observe) {
        list.remove(observe);
    }

    @Override
    public void notifyMes(String message) {
        list.forEach(x -> x.update(message));
    }
}
