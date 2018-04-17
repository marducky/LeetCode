package majors.openSource.youban.java;

import majors.openSource.youban.java.Tangshi.Tangshi;
import majors.openSource.youban.java.Tangshi.TangshiTwo;
import org.junit.Test;

import java.net.URLEncoder;

public class test1 {


    @Test
    public void testGetyouban() throws Exception {
        GetYouBanPageInfoHandler getYouBanPageInfoHandler = new GetYouBanPageInfoHandler("http://www.youban.com/mp3-t4416.html");
        System.out.println(getYouBanPageInfoHandler.getPageInfo());
    }

    @Test
    public void testGetList() throws Exception {
        Tangshi tangshi = new Tangshi();
        tangshi.getArrayLists().forEach(tangshiDetail -> {
//            System.out.println("id= " + tangshiDetail.getId() + ", name= " + tangshiDetail.getName() + ", mainUrl: " + tangshiDetail.getMainUrl() + ", vedioUrl: " + tangshiDetail.getVedioUrl() + ", mp3Url: " + tangshiDetail.getMp3Url());
            System.out.println(tangshiDetail);
        });
//        System.out.println(tangshi.getArrayLists());
        System.out.println(tangshi.getArrayLists().size());
    }

    @Test
    public void testGetListTwo() throws Exception {
        TangshiTwo tangshi = new TangshiTwo();
        tangshi.getArrayLists().forEach(tangshiDetail -> {
//            System.out.println("id= " + tangshiDetail.getId() + ", name= " + tangshiDetail.getName() + ", mainUrl: " + tangshiDetail.getMainUrl() + ", vedioUrl: " + tangshiDetail.getVedioUrl() + ", mp3Url: " + tangshiDetail.getMp3Url());
            System.out.println(tangshiDetail);
        });
//        System.out.println(tangshi.getArrayLists());
        System.out.println(tangshi.getArrayLists().size());
    }

    @Test
    public void testString() throws Exception {
        String t = "http://yuntv.letv.com/bcloud.swf?uu=e83fdad654&pu=55087b3b4d&vu=0763284719&auto_play=1&gpcflag=1";
        System.out.println(t.substring(t.indexOf("uu") + 3, t.indexOf("uu") + 13));
        System.out.println(t.substring(t.indexOf("vu") + 3, t.indexOf("vu") + 13));
        System.out.println(URLEncoder.encode("?", "UTF-8"));
    }
}
