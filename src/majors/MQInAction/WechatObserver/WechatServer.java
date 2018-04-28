package majors.MQInAction.WechatObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/27 14:56
 **/
public class WechatServer implements Observerable {
    private List<Observer> list;
    private String message;

    public WechatServer() {

        this.list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer o) {
        if (!list.isEmpty())
            list.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < list.size(); i++) {
            Observer observer = list.get(i);
            observer.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
