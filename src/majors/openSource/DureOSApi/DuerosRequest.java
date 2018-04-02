package majors.openSource.DureOSApi;

import lombok.Data;

@Data
public class DuerosRequest {
    private String nApiUrl;
    private int coordtype;

    private double longitude;
    private double latitude;
    private String crd = longitude + "_" + latitude;
    private String word;
    private int av;
    private String ak;
    private String cn;
    private String uuid;
    private String clientip;
    private String sign;
    private String c;

}
