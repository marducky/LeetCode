package knowledge.baseKnowledge._javaCore.international;

import java.util.Locale;

/**
 * @project: knowledge.baseKnowledge._javaCore.international
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/14 13:25
 **/
public class LocalesKn {
    String lan_name;

    public void setLan_name(String lan_name) {
        this.lan_name = lan_name;
    }

    public String getLan_name() {
        Locale locale = Locale.getDefault();
        return locale.getDisplayName();
    }

    public static void main(String[] args) {
        Locale localeForCn = Locale.SIMPLIFIED_CHINESE;
        System.out.println(localeForCn.getDisplayName());
        Locale localeForNew = new Locale("zh", "CN");
        //Locale(String language)
//        Locale(String language, String country)
//        Locale(String language, String country, String variant)
        Locale[] ls = Locale.getAvailableLocales();

        for (Locale locale : ls) {
            System.out.println("locale :" + locale);
        }

    }
}
