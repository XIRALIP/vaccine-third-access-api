package com.soundai.nat.institution.admin.framework.manager.factory;

import com.soundai.nat.institution.admin.framework.aspectj.lang.enums.BusinessStatus;
import com.soundai.nat.institution.admin.framework.aspectj.lang.enums.BusinessType;
import com.soundai.nat.institution.admin.framework.aspectj.lang.enums.ModuleType;
import com.soundai.nat.institution.admin.framework.constant.Constants;
import com.soundai.nat.institution.admin.framework.utils.IdUtils;
import com.soundai.nat.institution.admin.framework.utils.Messages;
import com.soundai.nat.institution.admin.framework.utils.ServletUtils;
import com.soundai.nat.institution.admin.framework.utils.ip.IpUtils;
import com.soundai.nat.institution.admin.framework.utils.spring.SpringUtils;
import com.soundai.nat.institution.admin.module.system.domain.SysOperLog;

import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 *
 * @author ruoyi
 */
public class AsyncFactory {
    /**
     * 记录登录信息
     *
     * @param username 用户名
     * @param status   状态
     * @param message  消息
     * @return 任务task
     */
//    public static TimerTask recordLogininfor(final String username, final String status, final String message) {
//        final String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
//        return new TimerTask() {
//            @Override
//            public void run() {
////                String address = AddressUtils.getRealAddressByIP(ip);
//                // 封装对象
//                SysOperLog operLog = new SysOperLog();
//                operLog.setOperId(IdUtils.fastSimpleUUID());
//                operLog.setOperUserName(username);
//                operLog.setOperIp(ip);
////                operLog.setOperLocation(address);
//                operLog.setOperModule(ModuleType.LOGIN_OR_LOGOUT.getDictValue());
//                if (Constants.LOGOUT.equals(status)) {
//                    operLog.setOperContent(message);
//                    operLog.setBusinessType(BusinessType.LOGOUT.getDictValue());
//                } else {
//                    operLog.setOperContent(Messages.getMessage(message));
//                    operLog.setBusinessType(BusinessType.LOGIN.getDictValue());
//                }
//                // 日志状态
//                if (Constants.LOGIN_SUCCESS.equals(status) || Constants.LOGOUT.equals(status)) {
//                    operLog.setStatus(BusinessStatus.SUCCESS.ordinal());
//                } else if (Constants.LOGIN_FAIL.equals(status)) {
//                    operLog.setStatus(BusinessStatus.FAIL.ordinal());
//                    operLog.setErrorMsg(message);
//                }
//                // 插入数据
//                SpringUtils.getBean(ISysOperLogService.class).insertOperlog(operLog);
//            }
//        };
//    }
//
//    /**
//     * 操作日志记录
//     *
//     * @param operLog 操作日志信息
//     * @return 任务task
//     */
//    public static TimerTask recordOper(final SysOperLog operLog) {
//        return new TimerTask() {
//            @Override
//            public void run() {
//                // 远程查询操作地点
////                operLog.setOperLocation(AddressUtils.getRealAddressByIP(operLog.getOperIp()));
//                SpringUtils.getBean(ISysOperLogService.class).insertOperlog(operLog);
//            }
//        };
//    }
}
