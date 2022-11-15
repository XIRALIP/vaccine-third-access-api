package com.soundai.nat.institution.admin.framework.utils;

import org.apache.commons.codec.binary.Base64;

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

/**
 * 西城家园解密工具类
 */
public class XiChengAESUtil {
	private static final String IV_STRING = "sdf4ddfsFD86Vdf2";
	private static final String encoding = "UTF-8";

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
		String base64 = new Base64().encodeToString(encryptedBytes);
		//进行url编码 去掉= ? &
		return URLEncoder.encode(base64, encoding);
	}

	public static String decryptAES(String content, String key) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		//URL解码
		content = URLDecoder.decode(content, encoding);
		// base64 解码
		byte[] encryptedBytes = Base64.decodeBase64(content);
		byte[] enCodeFormat = key.getBytes(encoding);
		SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");
		byte[] initParam = IV_STRING.getBytes(encoding);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		byte[] result = cipher.doFinal(encryptedBytes);
		return new String(result, encoding);
	}
	public static void main(String[] args) throws Exception {
		// 加解密测试数据
		String content = "875FAA849EE6DD816C6C73BCCC299E963FA7820205AB9C0CF9E382BB87061E6C3BC074452219BE894A686FEFD3CE18BC";
		System.out.println("加密前：" + content);

		String key = "XclgZZ2ga72gqvJR";
		System.out.println("解密密钥：" + key);

		String decrypt = decryptAES(content, key);
		System.out.println("解密后：" + decrypt);
	}
}
