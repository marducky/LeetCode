package knowledge.baseKnowledge._javaCore.encryption;

import java.security.MessageDigest;

/**
 * @project: knowledge.baseKnowledge._javaCore.encryption
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/03/02 16:27
 **/
public class SHAUtil {
    /**
     * 算法种类
     */
    private final static String KEY_SHA1 = "SHA-1";
    private final static String KEY_SHA256 = "SHA-256";
    private final static String KEY_SHA512 = "SHA-512";

    public static String encBySha1(String data) throws Exception {
        // 创建具有指定算法名称的信息摘要
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA1);
        // 使用指定的字节数组对摘要进行最后更新
        sha.update(data.getBytes());
        // 完成摘要计算
        byte[] bytes = sha.digest();
        // 将得到的字节数组变成字符串返回
        return HexUtil.byte2hex(bytes);
    }

    public static String encBySha256(String data) throws Exception {
        // 创建具有指定算法名称的信息摘要
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA256);
        // 使用指定的字节数组对摘要进行最后更新
        sha.update(data.getBytes());
        // 完成摘要计算
        byte[] bytes = sha.digest();
        // 将得到的字节数组变成字符串返回
        return HexUtil.byte2hex(bytes);
    }

    public static String encBySha512(String data) throws Exception {
        // 创建具有指定算法名称的信息摘要
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA512);
        // 使用指定的字节数组对摘要进行最后更新
        sha.update(data.getBytes());
        // 完成摘要计算
        byte[] bytes = sha.digest();
        // 将得到的字节数组变成字符串返回
        return HexUtil.byte2hex(bytes);
    }

    public static void main(String[] args) throws Exception {
        String key = "123";
        System.out.println(encBySha1(key));
        System.out.println(encBySha256(key));
        System.out.println(encBySha512(key));
    }

}
