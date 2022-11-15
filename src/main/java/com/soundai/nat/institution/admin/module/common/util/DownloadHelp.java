package com.soundai.nat.institution.admin.module.common.util;

import lombok.extern.log4j.Log4j2;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.MessageFormat;

/**
 * DownloadOption
 * @desc:
 * @version:
 * @createTime: 2020/4/30 14:11
 * @author:
 */
@Log4j2
public class DownloadHelp {

    private File file;

    private long startByte;

    private long endByte;

    private int httpServletResponseStatus;

    private long contentLength;

    private DownloadHelp(File file, long startByte, long endByte, int httpServletResponseStatus){
        this.file = file;
        this.startByte = startByte;
        this.endByte = endByte;
        this.httpServletResponseStatus = httpServletResponseStatus;
        this.contentLength = endByte - startByte + 1;
    }

    private DownloadHelp setHeaders(HttpServletResponse response, String rename) {
        if(httpServletResponseStatus>0){
            response.setStatus(httpServletResponseStatus);
        }
        String contentType = "application/octet-stream";
        response.setContentType(contentType);
        response.setHeader("Accept-Ranges", "bytes");
        response.setHeader("Content-Type", contentType);
        response.setHeader("Content-Length", String.valueOf(contentLength));
        response.setHeader("Content-Range", MessageFormat.format("bytes {0}-{1}/{2}", startByte, endByte, file.length()));
        try {
            response.setHeader("Content-Disposition", MessageFormat.format("attachment;filename={0}", URLEncoder.encode(StringUtils.isEmpty(rename) ? file.getName() : rename, "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            log.warn("set Content-Disposition header error", e);
        }
        return this;
    }

    private void download(HttpServletResponse response) {
        BufferedOutputStream outputStream = null;
        RandomAccessFile randomAccessFile = null;
        long transmitted = 0;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            outputStream = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[4096];
            int len = 0;
            randomAccessFile.seek(startByte);
            while ((transmitted + len) <= contentLength && (len = randomAccessFile.read(buff)) != -1) {
                outputStream.write(buff, 0, len);
                transmitted += len;
            }
            if (transmitted < contentLength) {
                len = randomAccessFile.read(buff, 0, (int) (contentLength - transmitted));
                outputStream.write(buff, 0, len);
                transmitted += len;
            }
            outputStream.flush();
            log.info(MessageFormat.format("下载完毕：{0}-{1}：{2}", startByte, endByte, transmitted));
        } catch (ClientAbortException e) {
            log.error(MessageFormat.format("用户停止下载：{0}-{1}：{2}", startByte, endByte, transmitted));
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    public void download(HttpServletResponse response, String rename) {
        this.setHeaders(response, rename).download(response);
    }

    public static DownloadHelp newInstance(File file, String range){
        long startByte = 0;
        long endByte = file.length() - 1;
        int httpServletResponseStatus = 0;
        if (range != null && range.contains("bytes=") && range.contains("-")) {
            range = range.substring(range.lastIndexOf("=") + 1).trim();
            String[] ranges = range.split("-");
            if (range.startsWith("-")) {
                endByte = Long.parseLong(ranges[1]);
            }else if (range.endsWith("-")) {
                startByte = Long.parseLong(ranges[0]);
            }else {
                startByte = Long.parseLong(ranges[0]);
                endByte = Long.parseLong(ranges[1]);
            }
            httpServletResponseStatus = HttpServletResponse.SC_PARTIAL_CONTENT;
        }
        return new DownloadHelp(file, startByte, endByte, httpServletResponseStatus);
    }

}
