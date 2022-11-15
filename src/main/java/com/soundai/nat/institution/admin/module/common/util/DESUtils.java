package com.soundai.nat.institution.admin.module.common.util;

import com.alibaba.fastjson.JSONObject;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;

public class DESUtils {
	public static final Charset CHARSET = Charset.forName("utf-8");

	/**
	 * 加密
	 * @param data
	 * @param sKey
	 * @return
	 */
	private static byte[] encrypt(byte[] data, String sKey) {
		try {
			byte[] key = sKey.getBytes();
			// 初始化向量
			IvParameterSpec iv = new IvParameterSpec(key);
			DESKeySpec desKey = new DESKeySpec(key);
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成securekey
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);
			// 现在，获取数据并加密
			// 正式执行加密操作
			return cipher.doFinal(data);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 * @param src
	 * @param sKey
	 * @return
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] src, String sKey) throws Exception {
		byte[] key = sKey.getBytes();
		// 初始化向量
		IvParameterSpec iv = new IvParameterSpec(key);
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(key);
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, iv);
		// 真正开始解密操作
		return cipher.doFinal(src);
	}

	/**
	 * 将二进制转换成16进制
	 *
	 * @param buf
	 * @return
	 */
	private static String parseByte2HexStr(byte buf[]) {
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

	/**
	 * 将16进制转换为二进制
	 *
	 * @param hexStr
	 * @return
	 */
	private static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1) return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	/**
	 * 加密
	 * @param srcStr
	 * @param charset
	 * @param sKey
	 * @return
	 */
	public static String encrypt(String srcStr, Charset charset, String sKey) {
		byte[] src = srcStr.getBytes(charset);
		byte[] buf = encrypt(src, sKey);
		return parseByte2HexStr(buf);
	}

	/**
	 * 解密
	 *
	 * @param hexStr
	 * @param sKey
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String hexStr, Charset charset, String sKey) throws Exception {
		byte[] src = parseHexStr2Byte(hexStr);
		byte[] buf = decrypt(src, sKey);
		return new String(buf, charset);
	}

	public static String encodeDES(String str){
		String password = null,encryptString = null;
		try {
			password = "XclgZZ2g";
			encryptString = encrypt(str, CHARSET, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptString;
	}

	public static String decodeDES(String str){
		String password = null,encryptString = null;
		try {
			password = "XclgZZ2g";
			encryptString = decrypt(str, CHARSET, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptString;
	}

	public static void main(String[] args) throws FileNotFoundException {
		try {
			//解密密码和方法
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("cardNo","110101199003079091");
			String telDe = DESUtils.encodeDES(jsonObject.toJSONString());
			String tel = DESUtils.decodeDES(telDe);
			System.out.println(tel);
			System.out.println(telDe);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
