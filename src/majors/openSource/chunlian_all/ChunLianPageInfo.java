package majors.openSource.chunlian_all;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @project: majors.openSource.chunlian_all
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/24 16:21
 **/
public class ChunLianPageInfo {
    private String title;
    private String url;
    private String line;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    private HashMap<String, String> hashMapArrayList;
    private ArrayList<ChunLianSingle> chunLianSingleArrayList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, String> getHashMapArrayList() {
        return hashMapArrayList;
    }

    public void setHashMapArrayList(HashMap<String, String> hashMapArrayList) {
        this.hashMapArrayList = hashMapArrayList;
    }

    public ArrayList<ChunLianSingle> getChunLianSingleArrayList() {
        return chunLianSingleArrayList;
    }

    public void setChunLianSingleArrayList(ArrayList<ChunLianSingle> chunLianSingleArrayList) {
        this.chunLianSingleArrayList = chunLianSingleArrayList;
    }
}
