package majors.openSource.DureOSApi;

import lombok.Data;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

@Data
public class UrlBuilder {
    private DuerosRequest duerosRequest;
    private Map<String, String> mUrl = new HashMap<>();
    private String url;

    private void buildParam(String key, String value) {
        mUrl.put(key, value);
    }

    private String createSign() {
        List<Map.Entry<String, String>> mHashMapEntryList = new ArrayList<Map.Entry<String, String>>(mUrl.entrySet());
        Collections.sort(mHashMapEntryList, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> firstMapEntry, Map.Entry<String, String> secondMapEntry) {
                return firstMapEntry.getKey().compareTo(secondMapEntry.getKey());
            }
        });
        String xString = "";
        for (int i = 0; i < mHashMapEntryList.size(); i++) {
            xString += mHashMapEntryList.get(i);
        }

        return xString;
    }

    private String getUrl() {
        StringBuffer sb = new StringBuffer("");
        sb.append(duerosRequest.getNApiUrl() + "?");
        System.out.println(mUrl.toString());
        mUrl.forEach((k, v) -> {
            if (!"sign".equals(k)) {
                sb.append("&" + k + "=" + v);
            }
        });
        sb.append("&sign=" + mUrl.get("sign"));
        return sb.toString().replaceFirst("&", "");

    }

    public String buildNlpUrl() throws UnsupportedEncodingException {

        // 1墨卡托,2国测坐标系,3百度坐标系
        buildParam("coordtype", "2");
        buildParam("word", URLEncoder.encode(duerosRequest.getWord(), "UTF-8"));
//        double lat = getLatitude();
//        double lng = getLongitude();
        buildParam("crd", duerosRequest.getCrd());
        buildParam("av", duerosRequest.getAv() + "");
        buildParam("ak", duerosRequest.getAk());
        buildParam("cn", duerosRequest.getCn());
        buildParam("uuid", duerosRequest.getUuid());
        buildParam("c", duerosRequest.getC());
        buildParam("sign", EncryptUtil.toMd5("123456" + createSign() + "123456"));
        String url = null;
        try {
            url = getUrl();
        } catch (Exception e) {

        }
        System.out.println(url);
        return url;
    }
}
