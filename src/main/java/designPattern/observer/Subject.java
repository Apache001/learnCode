package designPattern.observer;

/**
 * @author wangpengzhe
 * @date 2020/4/22 20:23
 */
public interface Subject {

    void attach(Observe observe);

    void detach(Observe observe);

    void notifyMes(String message);
}
