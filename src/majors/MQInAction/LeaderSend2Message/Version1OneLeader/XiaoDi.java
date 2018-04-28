package majors.MQInAction.LeaderSend2Message.Version1OneLeader;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/28 11:36
 **/
public class XiaoDi implements Xiami {
    String name;

    public XiaoDi(String name) {
        this.name = name;
    }

    @Override
    public void update(String command) {
        System.out.println(name + " 收到命令： " + command);
    }

}
