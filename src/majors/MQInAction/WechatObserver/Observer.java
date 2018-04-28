package majors.MQInAction.WechatObserver;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/27 14:53
 **/

/***
 * 抽象观察者
 * 定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
 * @author jstao
 *
 */
public interface Observer {
    //定义一个抽象观察者接口
    void update(String message);
}
