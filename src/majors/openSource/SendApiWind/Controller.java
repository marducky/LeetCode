package majors.openSource.SendApiWind;


import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;


/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/05/16 14:57
 **/
public class Controller {
    public static void main(String[] args) {
        // 第一个参数是Windows窗体的窗体类，第二个参数是窗体的标题。
        WinDef.HWND hwnd = User32.INSTANCE.FindWindow("#32770", null);
        User32.INSTANCE.ShowWindow(hwnd, 5);
        System.out.println(hwnd.getClass());
    }
}
