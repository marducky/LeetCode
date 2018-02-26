package majors.openSource.BevaSunSong.java;

/**
 * @project: majors.openSource.BevaSunSong.java
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/26 13:43
 **/
public class ErgeData {
    private String name;
    private String href;
    private String play_count;
    private String detail;
    private String id;
    private String authcode;
    private String videoLocation;

    public String getAuthcode() {
        return authcode;
    }

    public String getVideoLocation() {
        return videoLocation;
    }

    public void setVideoLocation(String videoLocation) {
        this.videoLocation = videoLocation;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getPlay_count() {
        return play_count;
    }

    public void setPlay_count(String play_count) {
        this.play_count = play_count;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
