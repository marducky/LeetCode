package majors.openSource.DureOSApi;

import org.apache.http.HttpException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static java.util.UUID.randomUUID;

public class demo {
    //    @Autowired
//    static DuerOSCaller duerOSCaller;
    public static void main(String[] args) throws UnsupportedEncodingException, IOException, HttpException {
        //main method
        UrlBuilder urlBuilder = new UrlBuilder();
        DuerosRequest duerosRequest = new DuerosRequest();
        duerosRequest.setNApiUrl("http://sandbox.codriverapi.baidu.com/codriverapi/robokit");
        duerosRequest.setAk("bn");
        duerosRequest.setAv(5);
        duerosRequest.setC("l");
        duerosRequest.setCn("20011104");

        duerosRequest.setCoordtype(2);
//     duerosRequest.setUuid("add48e01-644c-41e9-82c7-585476ee28cc");
        duerosRequest.setUuid(randomUUID().toString());
        duerosRequest.setCrd("116.407396_39.9042");
        duerosRequest.setWord("北京大学");
//     duerosRequest.setWord("%E6%88%91%E7%9A%84%E5%89%8D%E5%8D%8A%E7%94%9F%E7%9A%84%E4%B8%BB%E6%BC%94%E6%98%AF%E8%B0%81");
//     duerosRequest.setWord("%CE%D2%B5%C4%C7%B0%B0%EB%C9%FA%B5%C4%D6%F7%D1%DD%CA%C7%CB%AD");
        urlBuilder.setDuerosRequest(duerosRequest);
//        System.out.println(urlBuilder.buildNlpUrl());
//     String str="我的前半生的主演是谁";
//     try {

//      System.out.println(URLEncoder.encode(str,"UTF-8"));
//      System.out.println(URLDecoder.decode(str,"UTF-8"));
//     }catch (UnsupportedEncodingException e){
//      e.printStackTrace();
//     }//


        DuerOSCaller duerOSCaller = new DuerOSCaller();
        System.out.println(duerOSCaller.httpGet(urlBuilder.buildNlpUrl(), "GBK"));
    }


}



