package majors.openSource.GetUniScore.Model;

import lombok.Data;

import java.util.List;

@Data
public class SchoolBean {
    /**
     * schoolid : 38
     * schoolname : 北京交通大学
     * specialtyname : 土木类
     * localprovince : 宁夏
     * studenttype : 理科
     * year : 2017
     * batch : 一批
     * var : 545
     * var_score : 545
     * max : 553
     * min : 541
     * zyid : http://gkcx.eol.cn/schoolhtm/schoolSpecailtyMark/38/schoolSpecailtyMark.htm#28140079
     * url : http://gkcx.eol.cn/schoolhtm/schoolSpecailtyMark/38/schoolSpecailtyMark.htm#28140079
     * seesign : 0
     * firstrate : []
     * firstrateclass : []
     */

    private String schoolid;
    private String schoolname;
    private String specialtyname;
    private String localprovince;
    private String studenttype;
    private String year;
    private String batch;
    private String var;
    private String var_score;
    private String max;
    private String min;
    private String zyid;
    private String url;
    private String seesign;
    private List<?> firstrate;
    private List<?> firstrateclass;


}
