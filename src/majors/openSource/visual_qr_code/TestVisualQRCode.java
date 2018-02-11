package majors.openSource.visual_qr_code;

import java.awt.Color;
import java.io.IOException;

import org.junit.Test;

import majors.openSource.visual_qr_code.VisualQRCode;

/**
 * @author 黄本豪
 * @version V1.0
 * @Title: TestVisualQRCode.java
 * @Package com.boat.visualqrcode
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2016年12月1日 下午3:29:53
 */

public class TestVisualQRCode {

    //	private final String outPutPath = "C:\\Users\\dwdw\\Desktop\\";
    String projectName = System.getProperty("user.dir") + "\\src\\majors\\openSource\\visual_qr_code\\";
    String outPutPathForJanus = projectName + "out";
    String inImagesPathForJanus = projectName + "img";
    String inImagesPathForJanus2 = projectName + "img";

    @Test
    public void testPOSITIONRECTANGLE() {
        String url = "http://blog.csdn.net/weixin_41279060/article/details/78961532";
        try {
            VisualQRCode.createQRCode(url, "G:\\info\\NLPS_Code_Repos\\git\\LeetCode\\src\\majors\\openSource\\visual_qr_code\\img\\lg-logo.jpg", "G:\\info\\NLPS_Code_Repos\\git\\LeetCode\\src\\majors\\openSource\\visual_qr_code\\out\\" + "POSITIONRECTANGLE.png", 'M', new Color(2, 85, 43), null, null, null, true,
                    VisualQRCode.POSITION_DETECTION_SHAPE_MODEL_RECTANGLE, VisualQRCode.FILL_SHAPE_MODEL_RECTANGLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFILLCIRCLE() {
        String url = "http://blog.csdn.net/weixin_41279060/article/details/78961532";
        try {
            VisualQRCode.createQRCode(url, inImagesPathForJanus + "lg-logo.jpg", "G:\\info\\NLPS_Code_Repos\\git\\LeetCode\\src\\majors\\openSource\\visual_qr_code\\out\\" + "FILLCIRCLE.png", 'M', new Color(2, 85, 43), null, null, null, true,
                    VisualQRCode.POSITION_DETECTION_SHAPE_MODEL_ROUND_RECTANGLE, VisualQRCode.FILL_SHAPE_MODEL_CIRCLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLARGEIMG() {
        String url = "http://blog.csdn.net/weixin_41279060/article/details/78961532";
        try {
            VisualQRCode.createQRCode(url, inImagesPathForJanus + "xmyrz.jpg", outPutPathForJanus + "LARGEIMG.png", 'M', new Color(170, 24, 67), 800, 420, 200, false,
                    VisualQRCode.POSITION_DETECTION_SHAPE_MODEL_ROUND_RECTANGLE, VisualQRCode.FILL_SHAPE_MODEL_RECTANGLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
