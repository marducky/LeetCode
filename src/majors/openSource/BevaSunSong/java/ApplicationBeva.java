package majors.openSource.BevaSunSong.java;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @project: majors.openSource.BevaSunSong.java
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/26 16:10
 **/
public class ApplicationBeva {
    public static void main(String[] args) throws Exception {
//        Get2UrlSongItemInfoHandler get2UrlSongItemInfoHandler=new Get2UrlSongItemInfoHandler("http://g.beva.com/kan-erge--c10106.html");
        GetGBevaPageInfoHandler getGBevaPageInfoHandler = new GetGBevaPageInfoHandler("http://g.beva.com/kan-erge--c10106.html");
        String regexRole = "<div class=\"tips\">共有(.*)个</div>";
        PhrasePageHandler phrasePageHandler = new PhrasePageHandler(regexRole, getGBevaPageInfoHandler.getPageInfo().toString());
        int total = phrasePageHandler.phrasePageTotalVideo();
        System.out.println(total);
        int allPageCount = (total + 17) / 18;
        String demoUrl = "http://g.beva.com/kan-erge/data-moreErge-c10106-t4-p_PageFlag_.html";
        HashMap<String, HashMap<String, String>> stringHashMapHashMap = new HashMap<String, HashMap<String, String>>();
        HashMap<String, String> stringHashMapAll = new HashMap<String, String>();
        ArrayList<ErgeData> ergeDataArrayListAll = new ArrayList<ErgeData>();
        for (int i = 0; i < allPageCount; i++) {
            Get2UrlHandler get2UrlHandler = new Get2UrlHandler(demoUrl.replace("_PageFlag_", i + ""));
//            HashMap<String,String> hashMap=get2UrlHandler.getSongHashmap();
            stringHashMapAll.putAll(get2UrlHandler.getSongHashmap());
            ergeDataArrayListAll.addAll(get2UrlHandler.getSongClassArrayList());
//            stringHashMapHashMap.put(demoUrl.replace("_PageFlag_",i+""),hashMap);
        }
        String demo2 = "http://g.beva.com/kan-erge/data-itemInfo-i_itemId_.html";
        String demo3 = "http://g.beva.com/kan/data/itemVideo?code=_authCode_";
        for (ErgeData ergeData : ergeDataArrayListAll) {
            Get2UrlSongItemInfoHandler get2UrlSongItemInfoHandler = new Get2UrlSongItemInfoHandler(demo2.replace("_itemId_", ergeData.getId()));
            ergeData.setDetail(get2UrlSongItemInfoHandler.getJsonArray().getString("detail"));
            ergeData.setAuthcode(get2UrlSongItemInfoHandler.getJsonArray().getString("authcode"));
            Get2UrlSongLocationHandler get2UrlSongLocationHandler = new Get2UrlSongLocationHandler(demo3.replace("_authCode_", ergeData.getAuthcode()));
            ergeData.setVideoLocation(JSONObject.fromObject(get2UrlSongLocationHandler.getSongVedioLocation().getString("data")).getString("url"));
            DownVedioHandler downVedioHandler = new DownVedioHandler(ergeData.getName() + ".mp4", ergeData.getVideoLocation());
        }
        System.out.println(ergeDataArrayListAll.size());
        for (ErgeData ergeData : ergeDataArrayListAll) {
            System.out.println("====================");
            System.out.println(ergeData.getId() + ":" + ergeData.getName() + ":" + ergeData.getDetail() + ":" + ergeData.getAuthcode() + ":" + ergeData.getVideoLocation() + ":" + ergeData.getPlay_count());
        }

//        System.out.println(stringHashMapAll.size());
//        for (String s:stringHashMapAll.keySet()){
//            System.out.println("key:"+s+" value:"+stringHashMapAll.get(s));
//        }
//        new Write2FileHandler("allErGeList", Arrays.asList(stringHashMapAll));

    }
}
