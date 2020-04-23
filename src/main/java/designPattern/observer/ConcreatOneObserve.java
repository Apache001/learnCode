package designPattern.observer;

/**
 * @author wangpengzhe
 * @date 2020/4/22 20:34
 */
public class ConcreatOneObserve implements Observe {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConcreatOneObserve(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(name + "收到了:" + "msg");
    }
}
