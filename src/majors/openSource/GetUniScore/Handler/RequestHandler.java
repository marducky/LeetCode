package majors.openSource.GetUniScore.Handler;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


public class RequestHandler {
    public static String getErrorJson(String url) {
        //初始化客户端
        ClientConfig cc = new DefaultClientConfig();
        Client client = Client.create(cc);
        WebResource webResource = client.resource(url);
        //进行http连接
        ClientResponse response = webResource.get(ClientResponse.class);
        int status = response.getStatus();//获取状态码
        String textEntity = response.getEntity(String.class);//获取返回内容
        return textEntity;
    }

    public static void main(String[] args) {
        //main method
        System.out.println(getErrorJson("https://data-gkcx.eol.cn/soudaxue/querySpecialtyScore.html?messtype=jsonp&callback=jQuery18305074688691224565_1525435532975&provinceforschool=&schooltype=&page=1&size=19&keyWord=&schoolproperty=&schoolflag=&province=&fstype=&zhaoshengpici=&fsyear=&zytype=&_=1525435533599"));
    }
}
