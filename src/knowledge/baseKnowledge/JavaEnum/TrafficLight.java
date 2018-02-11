package knowledge.baseKnowledge.JavaEnum;

/**
 * @project: knowledge.baseKnowledge.JavaEnum
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/11 14:36
 **/
enum Signal {
    GREEN, YELLOW, RED
}

public class TrafficLight {
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.RED;
        }
    }
}
