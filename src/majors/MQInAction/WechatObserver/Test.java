package majors.MQInAction.WechatObserver;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/27 15:03
 **/

/**
 * 首先注册了三个用户，ZhangSan、LiSi、WangWu。公众号发布了一条消息"PHP是世界上最好用的语言！"，三个用户都收到了消息。
 * 用户ZhangSan看到消息后颇为震惊，果断取消订阅，这时公众号又推送了一条消息，此时用户ZhangSan已经收不到消息，其他用户
 * 还是正常能收到推送消息。
 */
public class Test {
    public static void main(String[] args) {
        WechatServer server = new WechatServer();
        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP 是世界上最好的语言");
        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");
/**
 * 这个模式是松偶合的。改变主题或观察者中的一方，另一方不会受到影像。
 * JDK中也有自带的观察者模式。但是被观察者是一个类而不是接口，限制了它的复用能力。
 * 在JavaBean和Swing中也可以看到观察者模式的影子。
 */

    }
}
