package com.soundai.nat.institution.admin.module.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author SunnyBoy_CF
 * @version 1.0.0
 * @ClassName JsonUtils.java
 * @Description TODO
 * @createTime 2020年12月20日 16:04:00
 */
public class HumpUtils {
    private static final Pattern linePattern = Pattern.compile("_(\\w)");

    /** 下划线转驼峰 */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher .group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /** 驼峰转下划线 性能较差 */
    public static String humpToLine(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    private static final Pattern humpPattern = Pattern.compile("[A-Z]");

    /** 驼峰转下划线 性能较好 */
    public static String humpToLine2(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher .group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {

        String lineToHump = lineToHump("hello_guys");

        System.out.println(lineToHump);

        System.out.println(humpToLine(lineToHump));

        System.out.println(humpToLine2(lineToHump));

    }
}
