package com.soundai.nat.institution.admin.module.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Objects;

/**
 * @author SunnyBoy_CF
 * @version 1.0.0
 * @ClassName TestFileUtil.java
 * @Description TODO
 * @createTime 2021年01月28日 15:53:00
 */
@Slf4j
public class ExportFileUtil {
    /**
     * 转换 B KB MB GB
     * @param size 文件大小长度
     * @return String
     */
    public static String getSize(long size) {
        StringBuffer bytes = new StringBuffer();
        DecimalFormat format = new DecimalFormat("###");
        if (size >= 1024 * 1024 * 1024) {
            double i = (size / (1024.0 * 1024.0 * 1024.0));
            bytes.append(format.format(i)).append("GB");
        }
        else if (size >= 1024 * 1024) {
            double i = (size / (1024.0 * 1024.0));
            bytes.append(format.format(i)).append("MB");
        }
        else if (size >= 1024) {
            double i = (size / (1024.0));
            bytes.append(format.format(i)).append("KB");
        }
        else if (size < 1024) {
            if (size <= 0) {
                bytes.append("0B");
            }
            else {
                bytes.append((int) size).append("B");
            }
        }
        return bytes.toString();
    }

    /**
     * Excel级联创建文件夹
     * mkdir()  创建此抽象路径名指定的目录。如果父目录不存在则创建不成功。
     * mkdirs() 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
     */
    public static void exportFolder(File file) {
        if (!file.exists()) {
            log.info("exportFolder：文件夹不存在，即将进行文件夹创建操作");
            file.mkdirs();
        }
    }

    /***
     * 删除文件夹
     * @param folderPath 文件夹完整绝对路径
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); // 删除完里面所有内容
            File myFilePath = new File(folderPath);
            myFilePath.delete(); // 删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 删除指定文件夹下所有文件
     * @param path 文件夹完整绝对路径
     */
    public static void delAllFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        if (!file.isDirectory()) {
            return;
        }
        String[] tempList = file.list();
        File temp;
        for (int i = 0; i < Objects.requireNonNull(tempList).length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);// 再删除空文件夹
            }
        }
    }
}
