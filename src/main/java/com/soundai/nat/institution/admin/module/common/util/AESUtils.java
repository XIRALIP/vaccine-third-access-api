package com.soundai.nat.institution.admin.module.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

//@Slf4j
public class AESUtils {

    private static final String IV_STRING = "sdf4ddfsFD86Vdf2";
    private static final String key = "MQKKQyLmk4FWIbI5";
    private static final String encoding = "UTF-8";
    public static  <T> T  decrypt(String content){
        try {
            return (T)  decryptAES(content,key);
        }catch (Exception e){
//            log.info("解密异常",e.getMessage());

        }
        return null;
    }
     public static  String encrypt(String content){
        try {
            return encryptAES(JSONObject.toJSONString(content),key);
        }catch (Exception e){
//            log.info("加密异常",e.getMessage());

        }
        return null;
    }
    public static String encryptAES(String content, String key) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] byteContent = content.getBytes(encoding);
        // 注意，为了能与 iOS 统一
        // 这里的 key 不可以使用 KeyGenerator、SecureRandom、SecretKey 生成
        byte[] enCodeFormat = key.getBytes(encoding);
        SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
        byte[] initParam = IV_STRING.getBytes(encoding);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
        // 指定加密的算法、工作模式和填充方式
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encryptedBytes = cipher.doFinal(byteContent);
        // 同样对加密后数据进行 base64 编码
        String base64 = Base64.getEncoder().encodeToString(encryptedBytes);
        //进行url编码 去掉= ? &
        return URLEncoder.encode(base64, encoding);
    }

    public static String decryptAES(String content, String key) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        //URL解码
        content = URLDecoder.decode(content, encoding);
        // base64 解码
        byte[] encryptedBytes = Base64.getDecoder().decode(content);
        byte[] enCodeFormat = key.getBytes(encoding);
        SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");
        byte[] initParam = IV_STRING.getBytes(encoding);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] result = cipher.doFinal(encryptedBytes);
        return new String(result, encoding);
    }
    public static String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public static void main(String[] args) throws Exception {


        //密码生成 todo 不对外
//        System.out.println(encryptPassword("szjk_u1Pass1234"));
//        System.out.println(encryptPassword("szjk_u1Pass4567"));
//        System.out.println(encryptPassword("szjk_u1Pass8910"));
        System.out.println(encryptPassword("szjk_u1Pass1213"));
//        System.out.println(encryptPassword("123456"));

        //参数加密 todo 不对外
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Appkey","SZJK_U4");
        jsonObject.put("AppSecret","szjk_u1Pass1213");

        String encryptAES = encryptAES(jsonObject.toJSONString(), key);
        String decryptAES = decryptAES(encryptAES, key);
        String decryptAES1 = decryptAES("vB6H6FSjG0NrbYMILgNnq8KDBf4rty92VfEQIh5q%2FzzURqiq7M87VMb8DmXKVKHxYGhVdhY23wRkZRB6Aj95hj1RQaQr%2BoyuSXtQQHQA9DE3%2FUowkp26GvaFHaa4ZZ4HcKxzVIl9iGrxpBc6Vq9O4NadDmN7TuCJIHKymkR6uti%2FtERGdAuYUFirmL3NRi54%2FAVlGUKfpLrKKiq%2F03JjogwTFmuZ%2BsWfneNPNXhFnPeYZ7lO16MCfLJAVmO7Bnh1k%2B6C2cMp6ao8wcsgr4LaTQlLvQN7L8EIr2TWHv6g7xE00ZTrXKa8Ln7q38wmX%2BeIt9MyFDAdBWwL0ECdxUX%2F7Rr9mLBB9t7YaX7ll53pneUu6VSLQqYRu9nRUHkkjkpx5OWJpmvjbyeqGsP1O3R%2FPzuf%2FIhLLgt5Heuykf3h7JgI0tX%2B%2F2jbs2Hs%2FGLc7ShXPf2K3g%2B%2FlddU1euvJnv77NAEmlXEdZ43P5qie9PpthBa1ZUKlnT0x5LW3BCweMBiSrwCJfG5zQPngQPlr4blA34n0hfWG%2FhAhs%2FQpNi%2BLwc%3D", key);


        System.out.println("加密后：" + encryptAES);
        System.out.println("解密后：" + decryptAES1);
        System.out.println("解密后：" + decryptAES);


        JSONObject json = new JSONObject();
        json.put("cardNo","320981199010195220");
        json.put("cardType","01");
        String encr = encryptAES(json.toJSONString(), key);
        System.out.println("身份信息加密后：" + encr);
        String en = decryptAES(encr, key);
        System.out.println("身份信息解密后：" + en);


        String decS = decrypt("vB6H6FSjG0NrbYMILgNnq8umXS%2FYiiDMNwIviPFBgR6C7xQBX11IVxkTYzkv9VKSVtBNHvBeRnfJP%2FpCIxJ1OUgnJtrEGnITVF8LFFQ2O%2B%2FipH%2FG5LJp6vbXn1bmunriBY%2BGhl3xvb3j8YX4HECuu9FebJBGNwflQvNHth%2FWwblKKH4vMTcq5Zkdi0q3QA%2FjtqPsIsGtegt2fIaDadg3R8SXAWxtrmI839KEKKx4HA%2FJHOLejpJR7gDtoieD03YuyQvbeYZqPSFCKkhKX%2BxYYOhkB2H3UC0TiwtxvPcsXDjbaMH1l5f1shTOKJuqUw9DtDw6yHKKZzScyByrJp1vG5VagnxKzpSgBbMlY1%2FH%2BzQ99mIJzk%2FeuS48TOWwt8alwzbYtuSFz51Kxda%2FmtbwvaBS5nEe8CR1MiAXJqpjb4rFtaiQebhG%2FXg6MWS1VSBRrnEwKbt%2BB7W9j%2FPIav0tifZrs2J1kyca3WuvjJhivEaJegCN31tMQKK5mbfFYNOXlR5ph0dTs8sFKUD5enxRGg%3D%3D");

        // 反转义java字符串
        String tokenInfoEsca = StringEscapeUtils.unescapeJava(decS);
        // 去除前后的双引号
        tokenInfoEsca = tokenInfoEsca.substring(1, tokenInfoEsca.length() -1);
        // 转换为json对象
//        JSONArray tokenJsonObj = JSON.parseArray(tokenInfoEsca);

        System.out.println("date信息解密后：" + tokenInfoEsca);
    }
}
