//https://m.baidu.com/from=1086k/bd_page_type=1/ssid=0/uid=0/pu=usm%401%2Csz%401320_1002%2Cta%40iphone_2_4.4_2_12137.1/baiduid=70C0B2F3F05C23ADF99051F7DEB86E4A/w=0_10_/t=iphone/l=3/tc?ref=www_iphone&lid=9373174859241529547&order=10&fm=alop&tj=www_normal_10_0_10_title&vit=osres&m=8&srd=1&cltj=cloud_title&asres=1&title=%E4%B8%AD%E5%9B%BDJava%E5%BC%80%E5%8F%91%E7%BD%91-Java%E6%8E%A7%E5%88%B6%E5%8F%B0%E7%9A%84%E5%86%85%E5%AE%B9%E5%A6%82%E4%BD%95%E8%BE%93%E5%87%BA%E5%88%B0%E6%96%87%E4%BB%B6%3F&dict=32&w_qd=IlPT2AEptyoA_yivHVWgWqLMIY13iiR1vJFvcaiwx0xVTMdBX8MNx6CndLglovt6yMEV23VsZki_Ra&tcplug=1&sec=27001&di=4bbfd20f6ca84263&bdenc=1&tch=124.325.286.1555.1.412&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ytOATq5953ybrWxBcZpUSOqAp7GEUz8sCPRpstMdGGcW7Uz7xQSeLdnp7oc78rhdK&eqid=821434df8eb6a000100000015a6147b8&wd=&clk_info=%7B%22srcid%22%3A1599%2C%22tplname%22%3A%22www_normal%22%2C%22t%22%3A1516324897457%2C%22xpath%22%3A%22div-a-h3-em2%22%7D&sfOpen=1
package tools.getHandler;

import knowledge.baseKnowledge.jsonDemo.GetNlpsJson;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;

public class PrintConsoleInfo {
    public void printConsoleInfoWithClear() {
        File file = new File("jvm.out");
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(fileOutputStream);
            System.setOut(printStream);
//            System.out.println("====================");
            GetNlpsJson getNlpsJson = new GetNlpsJson();
            getNlpsJson.getNlpsJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printConsoleInfoWithOutClear() {
        File file = new File("jvm.out");
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(fileOutputStream);
            PrintStream oldPrintStream = System.out;
//            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//            System.setOut(new PrintStream(byteArrayOutputStream));
            System.setOut(printStream);
//            System.out.println("++++++++++");
            System.out.println(oldPrintStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//    public static void main(String[] args){
//        PrintConsoleInfo printConsoleInfo=new PrintConsoleInfo();
//        printConsoleInfo.printConsoleInfoWithClear();
////        printConsoleInfo.printConsoleInfoWithOutClear();
//    }
}
