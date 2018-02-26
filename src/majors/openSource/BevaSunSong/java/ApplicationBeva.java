package majors.openSource.BevaSunSong.java;

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
        for (int i = 1; i < allPageCount + 1; i++) {
            Get2UrlHandler get2UrlHandler = new Get2UrlHandler(demoUrl.replace("_PageFlag_", i + ""));
//            HashMap<String,String> hashMap=get2UrlHandler.getSongHashmap();
            stringHashMapAll.putAll(get2UrlHandler.getSongHashmap());
//            stringHashMapHashMap.put(demoUrl.replace("_PageFlag_",i+""),hashMap);
        }
        System.out.println(stringHashMapAll.size());
    }
}
