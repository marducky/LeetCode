package majors.MQInAction.LeaderSend2Message.Version2MultiLeader;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/28 11:36
 **/
public class XiaoDi implements Xiami {
    String name;
    List<LeaderSay> leaderSays;

    public XiaoDi(String name) {
        this.name = name;
        leaderSays = new ArrayList<>();
    }


    @Override
    public void update(String command) {
        System.out.println(name + " 收到命令： " + command);
    }

    @Override
    public void seeLeader(LeaderSay say) {
        leaderSays.add(say);
    }

}
