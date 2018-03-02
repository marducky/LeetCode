package knowledge.baseKnowledge._javaCore.encryption;

/**
 * @project: knowledge.baseKnowledge._javaCore.encryption
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/03/02 16:32
 **/

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * DES 算法把 64 位的明文输入块变为 64 位的密文输出块，它所使用的密钥也是 64 位，其算法主要分为两步：
 * <p>
 * 初始置换
 * 其功能是把输入的 64 位数据块按位重新组合,并把输出分为 L0、R0 两部分，每部分各长 32 位，其置换规则为将输入的第 58 位换到第一位，第 50 位换到第 2 位 …… 依此类推,最后一位是原来的第 7 位。L0、R0 则是换位输出后的两部分，L0 是输出的左 32 位，R0 是右 32 位，例：设置换前的输入值为 D1 D2 D3 …… D64，则经过初始置换后的结果为：L0 = D58 D50 …… D8；R0 = D57 D49 …… D7。
 * <p>
 * 逆置换
 * 经过 16 次迭代运算后，得到 L16、R16，将此作为输入，进行逆置换，逆置换正好是初始置换的逆运算，由此即得到密文输出。
 * 3DES，也就是“Triple DES”，中文名“三重数据加密算法”，它相当于是对每个数据块应用三次 DES 加密算法。由于计算机运算能力的增强，原版 DES 密码的密钥长度变得容易被暴力破解；3DES 即是设计用来提供一种相对简单的方法，即通过增加 DES 的密钥长度来避免类似的攻击，而不是设计一种全新的块密码算法。
 * AES，全称为“Advanced Encryption Standard”，中文名“高级加密标准”，在密码学中又称 Rijndael 加密法，是美国联邦政府采用的一种区块加密标准。AES 加密算法作为新一代的数据加密标准汇聚了强安全性、高性能、高效率、易用和灵活等优点。AES 设计有三个密钥长度：128，192，256 位。相对而言，AES 的 128 密钥比 DES 的 56 密钥强了 1021 倍。
 */
public class DESUtil {
    private final static String KEY_DES = "DES";
    private static final String KEY_3_DES = "DESede";
    private final static String KEY_AES = "AES"; // 测试
    //长度8字节
    private final static String DES_KEY = "12345678";
    //长度24字节
    private final static String DES_3_KEY = "213456781234567812345678";
    //长度16，24，32字节
    private final static String AES_KEY = "1234567812345678";

    private static byte[] decByDes(byte[] data) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        DESKeySpec desKey = new DESKeySpec(DES_KEY.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_DES);
        SecretKey securekey = keyFactory.generateSecret(desKey);
        Cipher cipher = Cipher.getInstance(KEY_DES);
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        return cipher.doFinal(data);
    }

    private static byte[] encByDes(byte[] data) throws Exception {
        DESKeySpec desKey = new DESKeySpec(DES_KEY.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_DES);
        SecretKey securekey = keyFactory.generateSecret(desKey);
        Cipher cipher = Cipher.getInstance(KEY_DES);
        cipher.init(Cipher.ENCRYPT_MODE, securekey);
        return cipher.doFinal(data);
    }

    private static byte[] decBy3Des(byte[] data) throws Exception {
        SecureRandom random = new SecureRandom();
        SecretKey deskey = new SecretKeySpec(DES_3_KEY.getBytes(), KEY_3_DES);
        Cipher cipher = Cipher.getInstance(KEY_3_DES);
        cipher.init(Cipher.DECRYPT_MODE, deskey, random);
        return cipher.doFinal(data);
    }

    private static byte[] encBy3Des(byte[] data) throws Exception {
        SecureRandom random = new SecureRandom();
        SecretKey deskey = new SecretKeySpec(DES_3_KEY.getBytes(), KEY_3_DES);
        Cipher cipher = Cipher.getInstance(KEY_3_DES);
        cipher.init(Cipher.ENCRYPT_MODE, deskey, random);
        return cipher.doFinal(data);
    }

    private static byte[] decByAes(byte[] data) throws Exception {
        SecretKey deskey = new SecretKeySpec(AES_KEY.getBytes(), KEY_AES);
        Cipher cipher = Cipher.getInstance(KEY_AES);
        cipher.init(Cipher.DECRYPT_MODE, deskey);
        return cipher.doFinal(data);
    }

    private static byte[] encByAes(byte[] data) throws Exception {
        SecretKey deskey = new SecretKeySpec(AES_KEY.getBytes(), KEY_AES);
        Cipher cipher = Cipher.getInstance(KEY_AES);
        cipher.init(Cipher.ENCRYPT_MODE, deskey);
        return cipher.doFinal(data);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("DES密钥:\n" + DES_KEY);
        System.out.println("DES密钥字节长度:\n" + DES_KEY.getBytes().length);
        String word = "123";
        System.out.println("原文：" + word);
        System.out.println("=============DES=============");
        byte b[] = encByDes(word.getBytes());
        String encWord = new String(b);
        System.out.println("加密后：" + encWord);
        System.out.println("解密后：" + new String(decByDes(b)));
        System.out.println("=============3DES=============");
        System.out.println("3DES密钥:" + DES_3_KEY);
        System.out.println("3DES密钥字节长度:" + DES_3_KEY.getBytes().length);
        b = encBy3Des(word.getBytes());
        encWord = new String(b);
        System.out.println("加密后：" + encWord);
        System.out.println("解密后：" + new String(decBy3Des(b)));
        System.out.println("=============AES=============");
        System.out.println("AES密钥:" + AES_KEY);
        System.out.println("AES密钥字节长度:" + AES_KEY.getBytes().length);
        b = encByAes(word.getBytes());
        encWord = new String(b);
        System.out.println("加密后：" + encWord);
        System.out.println("解密后：" + new String(decByAes(b)));
    }
}

