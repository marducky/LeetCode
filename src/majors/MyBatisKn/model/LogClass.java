package majors.MyBatisKn.model;

import lombok.Data;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/05/10 10:19
 **/
@Data
public class LogClass {
    private Integer log_id;
    private String log_info;
    private String log_time;

    @Override
    public String toString() {
        return "LogClass [log_id=" + log_id + ", log_info=" + log_info + ", log_time" + log_time + "]";
    }
}
