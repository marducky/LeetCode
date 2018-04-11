package majors.openSource.youban.java;

import majors.openSource.youban.java.Tangshi.Tangshi;
import org.junit.Test;

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
            System.out.println("id= " + tangshiDetail.getId() + ", name= " + tangshiDetail.getName() + ", mainUrl: " + tangshiDetail.getMainUrl() + ", vedioUrl: " + tangshiDetail.getVedioUrl() + ", mp3Url: " + tangshiDetail.getMp3Url());
        });
//        System.out.println(tangshi.getArrayLists());
        System.out.println(tangshi.getArrayLists().size());
    }
}
