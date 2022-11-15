package com.soundai.nat.institution.admin.module.common.util;

import cn.hutool.core.io.FileUtil;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author SunnyBoy_CF
 * @version 1.0.0
 * @ClassName ZipUtil.java
 * @Description TODO
 * @createTime 2021年01月28日 16:10:00
 */
@Log4j2
public class ZipUtil {

    /**
     * 文件压缩
     * @param fileDic URL
     * @param dicUID UUID
     * @return ResponseEntity
     */
    public static File zipUtils(String fileDic, String dicUID) {
        //ZIP
        String zipPath = fileDic + dicUID + ".zip";
        File zipFile = cn.hutool.core.util.ZipUtil.zip(fileDic + dicUID, zipPath);
        //没有则新建文件夹
        ExportFileUtil.exportFolder(zipFile);

        String fileNameZip = dicUID +".zip";
        File file = new File(fileDic, fileNameZip);
        //没有则新建文件夹
        ExportFileUtil.exportFolder(file);

        InputStream input = null;
        byte[] buff;
        try {
            input = new FileInputStream(file);
            buff = new byte[input.available()]; // 获取文件大小
            input.read(buff);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        log.info("zip文件路径：{}", zipPath);
        log.info("zip文件size:{}", FileUtil.size(zipFile));
        return zipFile;
    }
}
