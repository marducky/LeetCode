package majors.openSource.DureOSApi;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/03 10:59
 **/
public class UnicodeToUtf8 {
    public static void main(String[] args) {
        String sss = "{\"errno\":0,\"message\":\"success\",\"raw_text\":\"\\u5bb6\\u6709\\u513f\\u5973\\u5bfc\\u6f14\\u662f\\u8c01\",\"result\":[{\"card_type\":\"kg\",\"intent\":\"universal_search\",\"tts_status\":{\"tts\":\"\\u5bb6\\u6709\\u513f\\u5973\\u7684\\u5bfc\\u6f14\\u662f\\u6797\\u4e1b\"},\"data\":{\"images\":[\"http:\\/\\/t12.baidu.com\\/it\\/u=1465287950,2219199135&fm=58\"],\"title\":\"\\u5bb6\\u6709\\u513f\\u5973\\u7684\\u5bfc\\u6f14\",\"source_category\":\"knowledge_graph_general\"}}],\"data_resource\":2,\"logid\":\"3527930002\",\"spend_time\":\"466ms\",\"uuid\":\"bn_811380bb-e672-4270-8ae1-c19f6e41c424\",\"time\":1522724328}";

        System.out.println(decode(sss));
        System.out.println(StringEscapeUtils.unescapeJava(sss));
    }

    public static String decode(String unicodeStr) {
        if (unicodeStr == null) {
            return null;
        }
        StringBuffer retBuf = new StringBuffer();
        int maxLoop = unicodeStr.length();
        for (int i = 0; i < maxLoop; i++) {
            if (unicodeStr.charAt(i) == '\\') {
                if ((i < maxLoop - 5)
                        && ((unicodeStr.charAt(i + 1) == 'u') || (unicodeStr
                        .charAt(i + 1) == 'U')))
                    try {
                        retBuf.append((char) Integer.parseInt(
                                unicodeStr.substring(i + 2, i + 6), 16));
                        i += 5;
                    } catch (NumberFormatException localNumberFormatException) {
                        retBuf.append(unicodeStr.charAt(i));
                    }
                else
                    retBuf.append(unicodeStr.charAt(i));
            } else {
                retBuf.append(unicodeStr.charAt(i));
            }
        }
        return retBuf.toString();
    }
}
