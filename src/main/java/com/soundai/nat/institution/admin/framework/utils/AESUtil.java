package com.soundai.nat.institution.admin.framework.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
    public static final String KEY = "b83439b86a1d8c7d";

    /** 填充模式 */
    private static final String transformation = "AES/CBC/PKCS5Padding";
    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @return
     */
    public static String encrypt(String content) {
        try {
            IvParameterSpec zeroIv = new IvParameterSpec(KEY.getBytes());
            SecretKeySpec key1 = new SecretKeySpec(KEY.getBytes(),"AES");
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, key1, zeroIv);
            byte[] encryptedData = cipher.doFinal(content.getBytes());
            String encryptResultStr = parseByte2HexStr(encryptedData);
            return encryptResultStr;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
}
