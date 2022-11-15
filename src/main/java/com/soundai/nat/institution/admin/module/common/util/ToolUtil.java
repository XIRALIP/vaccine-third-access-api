package com.soundai.nat.institution.admin.module.common.util;

import cn.hutool.core.lang.Assert;
import com.soundai.nat.institution.admin.module.common.annotation.NotNullArg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.query.Update;

import java.lang.reflect.Field;

/**
 * @Author: wangyu
 * @Date: Created 2020-11-19 13:39
 * @Description:
 * @Modified By:
 */
@Slf4j
public class ToolUtil {

    /**
     * 实体转换为update对象
     *
     * @param object
     * @return
     */
    public static Update beanToUpdate(Object object) {
        Update update = new Update();
        Field[] declaredFields = object.getClass().getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if (null != field.get(object)) {
                    update.set(field.getName(), field.get(object));
                }
            }
        } catch (IllegalAccessException e) {
            log.error("bean to update error:{}", e.getMessage());
        }
        return update;
    }

    public static Update beanToUpdateIncludeNull(Object object) {
        Update update = new Update();
        Field[] declaredFields = object.getClass().getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                field.setAccessible(true);
                update.set(field.getName(), field.get(object));
            }
        } catch (IllegalAccessException e) {
            log.error("bean to update error:{}", e.getMessage());
        }
        return update;
    }


    public static Update beanToUpdateByAnnotation(Object bean){
        Update update = new Update();
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if (null != field.get(bean)) {
                    if (null != field.getAnnotation(org.springframework.data.mongodb.core.mapping.Field.class)) {
                        update.set(field.getDeclaredAnnotation(org.springframework.data.mongodb.core.mapping.Field.class).value(), field.get(bean));
                    }
                }
            }
        }catch(IllegalAccessException e){
            log.error("bean to update error", e);
        }
        return update;
    }

    public static void checkNullArg(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                boolean isNullAnnotation = field.isAnnotationPresent(NotNullArg.class);
                if (isNullAnnotation) {
                    Assert.notNull(field.get(o), "获取参数 " + field.getName() + " 的值为 null！");
                }
            }
        } catch (IllegalAccessException e) {
            log.error("check null error: {}", e.getMessage());
        }
    }

    public static void checkNullObj(Object o) {
        boolean isNullAnnotation = o.getClass().isAnnotationPresent(NotNullArg.class);
        if (isNullAnnotation) {
            Field[] fields = o.getClass().getDeclaredFields();
            try {
                for (Field field : fields) {
                    field.setAccessible(true);
                    Assert.notNull(field.get(o), o.getClass().getSimpleName() + " 获取参数 " + field.getName() + " 的值为 null！");
                }
            } catch (IllegalAccessException e) {
                log.error("check null error: {}", e.getMessage());
            }
        }

    }
}
